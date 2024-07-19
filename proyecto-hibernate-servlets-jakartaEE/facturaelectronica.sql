-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 19-07-2024 a las 19:51:15
-- Versión del servidor: 8.2.0
-- Versión de PHP: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `facturaelectronica`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `idCliente` int NOT NULL,
  `tipoId` varchar(250) NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `direccion` varchar(250) NOT NULL,
  `telefono` varchar(250) NOT NULL,
  `ciudad` varchar(250) NOT NULL,
  `matriculaMercantil` varchar(250) NOT NULL,
  `responsFinancieras` varchar(250) NOT NULL,
  `formaPago` varchar(250) NOT NULL,
  `correoFe` varchar(250) NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `tipoId`, `nombre`, `direccion`, `telefono`, `ciudad`, `matriculaMercantil`, `responsFinancieras`, `formaPago`, `correoFe`) VALUES
(11111, '', 'Fabian', 'Poblado', '4445555', '', '', '', '', ''),
(22222, '', 'Yharsys', 'Mojica', '4446666', '', '', '', '', ''),
(33333, '', 'camilo', 'comuneros', '4447777', '', '', '', '', ''),
(44444, 'cc', 'Eliana Agredo', '4 esquina', '4444444444', 'Cali', 'mat4', '4 y 4', 'credito 1 dia', 'eliana@hotmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

DROP TABLE IF EXISTS `factura`;
CREATE TABLE IF NOT EXISTS `factura` (
  `idFactura` int NOT NULL AUTO_INCREMENT,
  `fechaRealizacion` date NOT NULL,
  `fechaVencimiento` date NOT NULL,
  `ordenCompra` varchar(250) NOT NULL,
  `remision` varchar(250) NOT NULL,
  `observaciones` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `iva` int DEFAULT NULL,
  `retefuente` int DEFAULT NULL,
  `total` int DEFAULT NULL,
  `idCliente` int DEFAULT NULL,
  PRIMARY KEY (`idFactura`),
  KEY `idCliente` (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE IF NOT EXISTS `item` (
  `idItem` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(250) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `cantidad` int NOT NULL,
  `valorUnidad` int NOT NULL,
  `idFactura` int NOT NULL,
  PRIMARY KEY (`idItem`),
  KEY `idFactura` (`idFactura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(250) NOT NULL,
  `contrasenia` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `usuario`, `contrasenia`) VALUES
(1, 'facturador', 's2010'),
(2, 'administrativo', 's2020');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`);

--
-- Filtros para la tabla `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `item_ibfk_1` FOREIGN KEY (`idFactura`) REFERENCES `factura` (`idFactura`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
