-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-10-2019 a las 13:58:05
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblanima`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `biblotecarios`
--

CREATE TABLE `biblotecarios` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiantes`
--

CREATE TABLE `estudiantes` (
  `id` int(11) NOT NULL,
  `orientacion` varchar(10) DEFAULT NULL,
  `prestamos_activos` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `codigo` varchar(30) NOT NULL,
  `link_portada` text DEFAULT NULL,
  `cant_ejemplares` int(11) DEFAULT NULL,
  `ejemplares_disponibles` bit(1) DEFAULT NULL,
  `autor` varchar(30) DEFAULT NULL,
  `genero` varchar(30) DEFAULT NULL,
  `editorial` varchar(30) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `numero_edicion` varchar(30) DEFAULT NULL,
  `anio_publicacion` date DEFAULT NULL,
  `isbn` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

CREATE TABLE `prestamos` (
  `id` int(11) NOT NULL,
  `devuelto` bit(1) DEFAULT NULL,
  `fecha_solicitud` date DEFAULT NULL,
  `fecha_devolucion` date DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `codigo_libro` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesores`
--

CREATE TABLE `profesores` (
  `id` int(11) NOT NULL,
  `orientacion` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `ci` int(11) DEFAULT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `apellido` varchar(30) DEFAULT NULL,
  `mail` varchar(30) DEFAULT NULL,
  `pass` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `tipo` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `ci`, `nombre`, `apellido`, `mail`, `pass`, `tipo`) VALUES
(20, 12344321, 'denis', 'fdennis', 'dennis@anima.edu.uy', 'denis2019', 'Estudiante');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `biblotecarios`
--
ALTER TABLE `biblotecarios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `isbn` (`isbn`);

--
-- Indices de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `codigo_libro` (`codigo_libro`);

--
-- Indices de la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ci` (`ci`),
  ADD UNIQUE KEY `mail` (`mail`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `biblotecarios`
--
ALTER TABLE `biblotecarios`
  ADD CONSTRAINT `biblotecarios_ibfk_1` FOREIGN KEY (`id`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD CONSTRAINT `estudiantes_ibfk_1` FOREIGN KEY (`id`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD CONSTRAINT `prestamos_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`),
  ADD CONSTRAINT `prestamos_ibfk_2` FOREIGN KEY (`codigo_libro`) REFERENCES `libros` (`codigo`);

--
-- Filtros para la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD CONSTRAINT `profesores_ibfk_1` FOREIGN KEY (`id`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
