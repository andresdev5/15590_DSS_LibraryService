INSERT INTO roles (id, name, description) VALUES (1, 'ADMIN', 'admin role') ON CONFLICT DO NOTHING;
INSERT INTO roles (id, name, description) VALUES (2, 'USER', 'user role') ON CONFLICT DO NOTHING;
INSERT INTO users (id, username, password, email, role_id) VALUES (1, 'admin', '$2a$12$/MZ.Vahjo1gq93oXHUWCPutAvIgX0sWvQuIzVZz30pmzTTFPMdTyi', 'admin@localhost', 1) ON CONFLICT DO NOTHING;
INSERT INTO users (id, username, password, email, role_id) VALUES (2, 'user', '$2a$12$7giYFmRTBqQ2qe/KGzlNWuLZchobozEtNvLRQcaNWxFBFWjU9zmou', 'user@localhost', 2) ON CONFLICT DO NOTHING;

INSERT INTO permissions (id, name, description) VALUES (1, 'CREATE_USER', 'create user permission') ON CONFLICT DO NOTHING;
INSERT INTO permissions (id, name, description) VALUES (2, 'READ_USER', 'read user permission') ON CONFLICT DO NOTHING;
INSERT INTO permissions (id, name, description) VALUES (3, 'UPDATE_USER', 'update user permission') ON CONFLICT DO NOTHING;
INSERT INTO permissions (id, name, description) VALUES (4, 'DELETE_USER', 'delete user permission') ON CONFLICT DO NOTHING;

INSERT INTO permissions (id, name, description) VALUES (5, 'CREATE_BOOKS', 'create books permission') ON CONFLICT DO NOTHING;
INSERT INTO permissions (id, name, description) VALUES (6, 'VIEW_BOOKS', 'view books permission') ON CONFLICT DO NOTHING;
INSERT INTO permissions (id, name, description) VALUES (7, 'UPDATE_BOOKS', 'update books permission') ON CONFLICT DO NOTHING;
INSERT INTO permissions (id, name, description) VALUES (8, 'DELETE_BOOKS', 'delete books permission') ON CONFLICT DO NOTHING;

INSERT INTO role_permission (role_id, permission_id) VALUES (1, 1) ON CONFLICT DO NOTHING;
INSERT INTO role_permission (role_id, permission_id) VALUES (1, 2) ON CONFLICT DO NOTHING;
INSERT INTO role_permission (role_id, permission_id) VALUES (1, 3) ON CONFLICT DO NOTHING;
INSERT INTO role_permission (role_id, permission_id) VALUES (1, 4) ON CONFLICT DO NOTHING;
INSERT INTO role_permission (role_id, permission_id) VALUES (1, 5) ON CONFLICT DO NOTHING;
INSERT INTO role_permission (role_id, permission_id) VALUES (1, 6) ON CONFLICT DO NOTHING;
INSERT INTO role_permission (role_id, permission_id) VALUES (1, 7) ON CONFLICT DO NOTHING;
INSERT INTO role_permission (role_id, permission_id) VALUES (1, 8) ON CONFLICT DO NOTHING;

INSERT INTO role_permission (role_id, permission_id) VALUES (2, 2) ON CONFLICT DO NOTHING;
INSERT INTO role_permission (role_id, permission_id) VALUES (2, 6) ON CONFLICT DO NOTHING;
