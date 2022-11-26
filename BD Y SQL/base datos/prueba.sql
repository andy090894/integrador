-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-08-2022 a las 00:44:50
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `prueba`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comida`
--

CREATE TABLE `comida` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(100) CHARACTER SET latin1 NOT NULL,
  `Precio` varchar(100) CHARACTER SET latin1 NOT NULL,
  `Contenido` varchar(60) CHARACTER SET latin1 NOT NULL,
  `UrlC` text CHARACTER SET utf32 COLLATE utf32_swedish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `comida`
--

INSERT INTO `comida` (`Id`, `Nombre`, `Precio`, `Contenido`, `UrlC`) VALUES
(1, '1/4 de Pollo a la Brasa', '15.00', '1/4 de pollo + papas fritas + ensalada ', 'http://192.168.1.70/img/cuartopollo.jpg'),
(2, '1/2 Pollo a la Brasa', '25.00', '1/2 Pollo a la Brasa + papas fritas + ensalada', 'http://192.168.1.70/img/mediopollo.jpg'),
(3, '1 Pollo a la brasa', '45.00', '1 pollo a la brasa + papas fritas + ensalada ', 'http://192.168.1.70/img/pollo%20a%20la%20brasa.jpg'),
(4, 'Combo Fogon', '50', '1 Pollo a la Brasa+ Papas fritas+ ensalada + gaseosa 1L', 'http://192.168.1.70/img/combofamiliar.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `universidad`
--

CREATE TABLE `universidad` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(100) CHARACTER SET latin1 NOT NULL,
  `Direccion` varchar(100) CHARACTER SET latin1 NOT NULL,
  `Distrito` varchar(60) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `universidad`
--

INSERT INTO `universidad` (`Id`, `Nombre`, `Direccion`, `Distrito`) VALUES
(1, 'Universidad Tecnológica del Perú', 'Av. 28 de Julio con Av. Pettit Thouars', 'Lima'),
(2, 'Universidad Católica del Perú', 'Av. Universitaria 2300', 'San Miguel'),
(3, 'Universidad Nacional Mayor de San Marcos', 'Av. Universitaria 3100', 'Lima'),
(4, 'Universidad Privada de Ciencias Aplicadas', 'Av. Salaverry 1500', 'San \r\nIsidro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `edad` int(11) NOT NULL,
  `clave` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `usuario`, `nombre`, `apellido`, `edad`, `clave`) VALUES
(18, 'l', 'l', 'l', 12, 'l'),
(19, 'n', 'n', 'n', 12, 'n'),
(20, 'j', 'j', 'j', 12, 'j'),
(21, 'm', 'm', 'm', 14, 'm'),
(22, 'o', 'o', 'o', 14, 'o'),
(23, 'h', 'h', 'h', 13, 'h'),
(24, 'v', 'v', 'v', 14, 'v'),
(25, 'c', 'c', 'c', 15, 'c'),
(26, 'o', 'o', 'o', 15, 'oo'),
(27, 'c', 'c', 'c', 14, 'c'),
(28, 'z', 'z', 'zz', 1, 'z'),
(29, 'c', 'c', 'c', 1, 'cc'),
(30, 'q', 'q', 'q', 12, 'q'),
(31, 'd', 'd', 'd', 12, 'd'),
(32, 's', 's', 's', 15, 's'),
(33, 't', 't', 't', 13, 't'),
(34, 'U', 'UU\n', 'U', 15, 'U'),
(35, 'h', 'h', 'h', 21, 'h'),
(36, 'a', 'a', 'a', 13, 'a'),
(37, 'x\n', 'x', 'x', 143, 'xx'),
(38, 'c', 'c', 'c', 63, 'c'),
(39, 'q', 'q', 'q', 14, 'q'),
(40, 'jo', 'jo', 'jo', 14, 'jo'),
(41, 're', 're', 're', 14, 're'),
(42, 'very', 'very', 'very', 15, 'very'),
(43, 'we', 'we', 'we', 14, 'we'),
(44, 'well', 'well', 'well', 12, 'well'),
(45, 'z', 'z', 'z', 12, 'z'),
(46, 'g', 'g', 'g', 14, 'g'),
(47, 'y', 'y', 'y', 15, 'y'),
(48, 'v', 'v', 'v', 14, 'v'),
(49, 'v', 'v', 'v', 12, 'v'),
(50, 'b', 'b', 'b', 14, 'b'),
(51, 'y', 'y', 'y', 14, 'y'),
(52, 'q', 'q', 'q', 14, 'q'),
(53, 'v', 'v', 'v', 14, 'v'),
(54, 'vv', 'v', 'v', 14, 'v'),
(55, 'Q', 'Q', 'Q', 14, 'Q'),
(56, 'v', 'v', 'v', 13, 'v'),
(57, 'q', 'q', 'q', 13, 'q'),
(58, 'q', 'q', 'q', 12, 'q'),
(59, 'q', 'q', 'q', 13, 'q'),
(60, 'q', 'q', 'q', 14, 'q'),
(61, 'ricardo', 'ricardo', 'ricardo', 15, '123'),
(62, 'q', 'q', 'q', 14, 'q');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comida`
--
ALTER TABLE `comida`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `universidad`
--
ALTER TABLE `universidad`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comida`
--
ALTER TABLE `comida`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `universidad`
--
ALTER TABLE `universidad`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
