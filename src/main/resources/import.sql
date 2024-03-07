-- Inserts para alumnos
INSERT INTO usuario (nombre, apellido, enabled, email, username, password) VALUES ('Juan', 'Sistema', true, 'admin@example.com', 'obijuan', '$2a$12$8XtyEhg5sm8NYZHgaOez9ueN7qSFMhginmCavQbtMXyHiIci/JgqO');
INSERT INTO usuario (nombre, apellido, enabled, email, username, password) VALUES ('Maria', 'Prueba', true, 'usuario@example.com', 'mariona', 'password');

-- Inserts para usuarios para profesores
INSERT INTO usuario (nombre, apellido, enabled, email, username, password) VALUES ('Carlos', 'Gómez', true, 'carlos@example.com', 'carlosg', '$2a$12$8XtyEhg5sm8NYZHgaOez9ueN7qSFMhginmCavQbtMXyHiIci/JgqO');
INSERT INTO usuario (nombre, apellido, enabled, email, username, password) VALUES ('Laura', 'Díaz', true, 'laura@example.com', 'laurad', '$2a$12$8XtyEhg5sm8NYZHgaOez9ueN7qSFMhginmCavQbtMXyHiIci/JgqO');

-- Inserts para usuarios para gestores
INSERT INTO usuario (nombre, apellido, enabled, email, username, password) VALUES ('Gestor', 'Carlos', true, 'gestor_carlos@example.com', 'gestor_carlos', '$2a$12$8XtyEhg5sm8NYZHgaOez9ueN7qSFMhginmCavQbtMXyHiIci/JgqO');
INSERT INTO usuario (nombre, apellido, enabled, email, username, password) VALUES ('Gestor', 'Laura', true, 'gestor_laura@example.com', 'gestor_laura', '$2a$12$8XtyEhg5sm8NYZHgaOez9ueN7qSFMhginmCavQbtMXyHiIci/JgqO');


-- Inserts para alumnos
INSERT INTO alumno (nombre, apellidos, email, password, telefono, usuario_id) VALUES ('Juan', 'Pérez', 'juan@example.com', 'password', '123456789', 1);
INSERT INTO alumno (nombre, apellidos, email, password, telefono, usuario_id) VALUES ('María', 'López', 'maria@example.com', 'password123', '987654321', 2);

-- Inserts para profesores
INSERT INTO profesor (nombre, apellidos, email, password, usuario_id) VALUES ('Carlos', 'Gómez', 'carlos@example.com', 'password', 3);
INSERT INTO profesor (nombre, apellidos, email, password, usuario_id) VALUES ('Laura', 'Díaz', 'laura@example.com', 'password123', 4);

-- Inserts para gestores
INSERT INTO gestor (usuario_id, password) VALUES (5, 'password');
INSERT INTO gestor (usuario_id, password) VALUES (6, 'password123');

-- Inserts para asignaturas
INSERT INTO asignatura (nombre, curso, ciclo) VALUES ('Matemáticas I', '1º', 'Bachillerato');
INSERT INTO asignatura (nombre, curso, ciclo) VALUES ('Lengua Española', '1º', 'Bachillerato');
INSERT INTO asignatura (nombre, curso, ciclo) VALUES ('Historia del Arte', '2º', 'Bachillerato');
INSERT INTO asignatura (nombre, curso, ciclo) VALUES ('Química', '2º', 'Bachillerato');
INSERT INTO asignatura (nombre, curso, ciclo) VALUES ('Programación Java', '1º', 'Ciclo Formativo');
INSERT INTO asignatura (nombre, curso, ciclo) VALUES ('Base de Datos', '2º', 'Ciclo Formativo');

-- Inserts para asignatura_alumno (relación muchos a muchos)
INSERT INTO asignatura_alumno (alumno_id, asignatura_id) VALUES (1, 1);
INSERT INTO asignatura_alumno (alumno_id, asignatura_id) VALUES (1, 2);
INSERT INTO asignatura_alumno (alumno_id, asignatura_id) VALUES (2, 3);
INSERT INTO asignatura_alumno (alumno_id, asignatura_id) VALUES (2, 4);
INSERT INTO asignatura_alumno (alumno_id, asignatura_id) VALUES (3, 5);
INSERT INTO asignatura_alumno (alumno_id, asignatura_id) VALUES (3, 6);

-- Inserts para asignatura_profesor (relación muchos a muchos)
INSERT INTO asignatura_profesor (asignatura_id, profesor_id) VALUES (1, 1);
INSERT INTO asignatura_profesor (asignatura_id, profesor_id) VALUES (2, 2);
INSERT INTO asignatura_profesor (asignatura_id, profesor_id) VALUES (3, 1);
INSERT INTO asignatura_profesor (asignatura_id, profesor_id) VALUES (4, 2);
INSERT INTO asignatura_profesor (asignatura_id, profesor_id) VALUES (5, 1);
INSERT INTO asignatura_profesor (asignatura_id, profesor_id) VALUES (6, 2);
