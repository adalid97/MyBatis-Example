# MyBatis-Example

```sql
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Base de datos: `ejermybatis`
--

CREATE TABLE `campo` (
  `idCampo` int(11) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `aforo` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `reserva` (
  `idReserva` int(11) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `horaInicio` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `horaFin` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `idCampo` int(11) NOT NULL,
  `idDeporte` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `tipodeporte` (
  `idDeporte` int(11) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

ALTER TABLE `campo`
  ADD PRIMARY KEY (`idCampo`);

ALTER TABLE `reserva`
  ADD PRIMARY KEY (`idReserva`),
  ADD KEY `FK_IDCAMPO` (`idCampo`),
  ADD KEY `FK_IDDEPORTE` (`idDeporte`);

ALTER TABLE `tipodeporte`
  ADD PRIMARY KEY (`idDeporte`);

ALTER TABLE `campo`
  MODIFY `idCampo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

ALTER TABLE `reserva`
  MODIFY `idReserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

ALTER TABLE `tipodeporte`
  MODIFY `idDeporte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

ALTER TABLE `reserva`
  ADD CONSTRAINT `FK_IDCAMPO` FOREIGN KEY (`idCampo`) REFERENCES `campo` (`idCampo`),
  ADD CONSTRAINT `FK_IDDEPORTE` FOREIGN KEY (`idDeporte`) REFERENCES `tipodeporte` (`idDeporte`);
COMMIT;
```
