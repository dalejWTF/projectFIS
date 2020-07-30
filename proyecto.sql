-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 30, 2020 at 07:28 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.2.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `proyecto`
--

-- --------------------------------------------------------

--
-- Table structure for table `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `idPropietario` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `descripcion` text NOT NULL,
  `cantidad` double(10,2) NOT NULL,
  `precio` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `producto`
--

INSERT INTO `producto` (`idProducto`, `idPropietario`, `nombre`, `tipo`, `descripcion`, `cantidad`, `precio`) VALUES
(1234, 1231231231, 'papa', 'Hortaliza', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.', 970.00, 0.30),
(2345, 1231231231, 'lechuga', 'Legumbre', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.', 100.00, 0.50),
(3456, 1231231231, 'manzana', 'Fruta', 'Lorem Ipsum is simply dummy text of the printing a', 300.00, 1.30),
(3578, 1472583691, 'Uva', 'Fruta', 'some text here', 500.00, 2.50),
(3698, 1592634870, 'arbeja', 'Legumbre', 'something to say here', 100.00, 1.50),
(4321, 1231231231, 'Frejol', 'Legumbre', 'Lorem Ipsum is simply dummy text of the printing a', 300.00, 1.20),
(4562, 1147253698, 'Kiwi', 'Fruta', 'some text here', 300.00, 1.00),
(4757, 1592634870, 'lenteja', 'Legumbre', 'descripcion random', 100.00, 0.80),
(8299, 1592634870, 'zanahoria', 'Hortaliza', 'descripcion x', 200.00, 0.25),
(8852, 1472583691, 'Pera', 'Fruta', 'dasdcas', 200.00, 1.50),
(9954, 1472583691, 'Col', 'Hortaliza', 'something here', 20.00, 0.60);

-- --------------------------------------------------------

--
-- Table structure for table `repartidor`
--

CREATE TABLE `repartidor` (
  `idUsuario` int(11) NOT NULL,
  `idVehiculo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `repartidor`
--

INSERT INTO `repartidor` (`idUsuario`, `idVehiculo`) VALUES
(1874652130, 'AAA-123'),
(1147253698, 'HQ891B'),
(1598742360, 'BBB-123'),
(1122336654, 'QB830H');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `dni` int(13) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `telefono` varchar(13) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `pass` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`dni`, `nombre`, `apellido`, `telefono`, `correo`, `pass`) VALUES
(1122336654, 'repartidor 4', '4', '0996655221', 'asdfg@gmail.com', '123'),
(1147253698, 'repartidor 2', '2', '0987410522', 'correo1@live.com', '123'),
(1231231231, 'usuario', '1', '0912345678', 'micorreo@gmail.com', '123'),
(1472583691, 'usuario2', '2', '0986532741', 'anyone@gmail.com', '123'),
(1592634870, 'usuario3', '3', '0986592741', 'someone@live.com', '123'),
(1598742360, 'repartidor 3', '3', '0987405210', 'qwerty@live.com', '123'),
(1874652130, 'repartidor 1', '1', '0993265140', 'random@gmail.com', '123');

-- --------------------------------------------------------

--
-- Table structure for table `vehiculo`
--

CREATE TABLE `vehiculo` (
  `placa` varchar(10) NOT NULL,
  `marca` varchar(30) NOT NULL,
  `modelo` varchar(30) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `color` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vehiculo`
--

INSERT INTO `vehiculo` (`placa`, `marca`, `modelo`, `tipo`, `color`) VALUES
('AAA-123', 'Chevrolet', 'Sail', 'Auto', 'gris'),
('BBB-123', 'Hyundai', 'Accent', 'Auto', 'plata'),
('HQ891B', 'Yamaha', 'FZ-25', 'Moto', 'negro'),
('QB830H', 'Kawasaki', 'Ninja 1000SX', 'Moto', 'negro y verde');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `idPropietario` (`idPropietario`);

--
-- Indexes for table `repartidor`
--
ALTER TABLE `repartidor`
  ADD KEY `idUsuario` (`idUsuario`),
  ADD KEY `idVehiculo` (`idVehiculo`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`dni`);

--
-- Indexes for table `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD PRIMARY KEY (`placa`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `idPropietario` FOREIGN KEY (`idPropietario`) REFERENCES `usuario` (`dni`);

--
-- Constraints for table `repartidor`
--
ALTER TABLE `repartidor`
  ADD CONSTRAINT `idUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`dni`),
  ADD CONSTRAINT `idVehiculo` FOREIGN KEY (`idVehiculo`) REFERENCES `vehiculo` (`placa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
