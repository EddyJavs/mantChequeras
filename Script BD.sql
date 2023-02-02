-- Creación de la tabla de clientes
CREATE TABLE cliente (
  cliente_id INT IDENTITY(1,1) PRIMARY KEY,
  nombre NVARCHAR(100) NOT NULL,
  direccion NVARCHAR(255) NOT NULL,
  telefono NVARCHAR(20) NOT NULL
);

-- Creación de la tabla de tipos de cuenta (Monetaria, Ahorro)
CREATE TABLE tipo_cuenta(
	tipoCuenta_id INT IDENTITY(1,1) PRIMARY KEY,
	descripcion NVARCHAR(255) NOT NULL
);

-- Creación de la tabla de cuentas
CREATE TABLE cuenta (
  cuenta_id INT IDENTITY(1,1) PRIMARY KEY,
  cliente_id INT NOT NULL,
  fechaApertura DATE NOT NULL,
  tipoCuenta_id INT NOT NULL,
  monto DECIMAL(10,2) NOT NULL,
  FOREIGN KEY (cliente_id) REFERENCES cliente (cliente_id),
  FOREIGN KEY (tipoCuenta_id) REFERENCES tipo_cuenta (tipoCuenta_id)
);


-- Creación de la tabla de chequeras
CREATE TABLE chequera (
  chequera_id INT IDENTITY(1,1) PRIMARY KEY,
  cuenta_id INT NOT NULL,
  fecha_asignacion DATE NOT NULL,
  FOREIGN KEY (cuenta_id) REFERENCES cuenta (cuenta_id)
);

-- Creación de la tabla de cheques
CREATE TABLE cheque (
  cheque_id INT IDENTITY(1,1) PRIMARY KEY,
  chequera_id INT NOT NULL,
  numeroCheque INT NOT NULL,
  beneficiario NVARCHAR(100) NULL,
  monto DECIMAL(10,2) NULL,
  fecha DATE NULL,
  FOREIGN KEY (chequera_id) REFERENCES chequera (chequera_id)
);

