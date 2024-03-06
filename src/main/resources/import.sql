-- Inserts para alumnos
INSERT INTO alumno (nombre, apellidos, email, password, telefono, usuario) VALUES ('Juan', 'Pérez', 'juan@example.com', 'password', '123456789', 'obijuan');
INSERT INTO alumno (nombre, apellidos, email, password, telefono, usuario) VALUES ('María', 'López', 'maria@example.com', 'password123', '987654321', 'marialo');
INSERT INTO alumno (nombre, apellidos, email, password, telefono, usuario) VALUES ('Pedro', 'González', 'pedro@example.com', 'password456', '456789123', 'pedrog');

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

-- Inserts para profesores
INSERT INTO profesor (nombre, apellidos, email, password, usuario) VALUES ('Carlos', 'Gómez', 'carlos@example.com', 'password', 'carlosg');
INSERT INTO profesor (nombre, apellidos, email, password, usuario) VALUES ('Laura', 'Díaz', 'laura@example.com', 'password123', 'laurad');

-- Inserts para asignatura_profesor (relación muchos a muchos)
INSERT INTO asignatura_profesor (asignatura_id, profesor_id) VALUES (1, 1);
INSERT INTO asignatura_profesor (asignatura_id, profesor_id) VALUES (2, 2);
INSERT INTO asignatura_profesor (asignatura_id, profesor_id) VALUES (3, 1);
INSERT INTO asignatura_profesor (asignatura_id, profesor_id) VALUES (4, 2);
INSERT INTO asignatura_profesor (asignatura_id, profesor_id) VALUES (5, 1);
INSERT INTO asignatura_profesor (asignatura_id, profesor_id) VALUES (6, 2);

-- Inserts para gestores
INSERT INTO gestor (usuario, password) VALUES ('gestor_carlos', 'password');
INSERT INTO gestor (usuario, password) VALUES ('gestor_laura', 'password123');

-- Inserts para usuarios generales
INSERT INTO usuario (nombre, apellido, enabled, email, username, password) VALUES ('admin', 'Sistema', true, 'admin@example.com', 'admin', '$2a$12$8XtyEhg5sm8NYZHgaOez9ueN7qSFMhginmCavQbtMXyHiIci/JgqO');
INSERT INTO usuario (nombre, apellido, enabled, email, username, password) VALUES ('Usuario', 'Prueba', true, 'usuario@example.com', 'usuario', 'password');
