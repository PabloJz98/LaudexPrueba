SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `laudex`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumns`
--

CREATE TABLE `alumns` (
  `id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `SecondLastName` varchar(50) DEFAULT NULL,
  `Birthday` date NOT NULL,
  `Gender` text NOT NULL,
  `StudyLevel` varchar(100) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Phone` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alumns`
--

INSERT INTO `alumns` (`id`, `Name`, `LastName`, `SecondLastName`, `Birthday`, `Gender`, `StudyLevel`, `Email`, `Phone`, `created_at`, `updated_at`) VALUES
(1, 'Juan Pablo', 'Zuniga', 'Salazar', '1998-02-04', 'Masculino', 'Licenciatura', 'juanpablo9844@gmail.com', 1044758, '2023-02-09 10:08:49', '2023-02-09 10:08:49');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Surname` varchar(50) DEFAULT NULL,
  `Role` varchar(20) DEFAULT NULL,
  `Email` varchar(255) NOT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Image` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `RememberToken` varchar(255) DEFAULT NULL,
  `Password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `Name`, `Surname`, `Role`, `Email`, `Description`, `Image`, `created_at`, `updated_at`, `RememberToken`, `Password`) VALUES
(1, 'Juan Pablo', 'Zuniga', 'juanpablo9884@gmail.com', NULL, NULL, '2023-02-09 23:47:20', '2023-02-09 23:47:20', NULL, 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3');

--
-- ??ndices para tablas volcadas
--

--
-- Indices de la tabla `alumns`
--
ALTER TABLE `alumns`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumns`
--
ALTER TABLE `alumns`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;