insert into pages(id) values('start');
insert into pages(id) values('home');
insert into pages(id) values('about');
insert into pages(id) values('logout');
insert into pages(id) values('info');
insert into pages(id) values('users');
insert into pages(id) values('contacts');
insert into pages(id) values('company');
insert into pages(id) values('main');
insert into pages(id) values('privacy');
insert into pages(id) values('products');

insert into users(id) values('admin');
insert into users(id) values('user');

insert into visits(id, user_id, page_id, created) values(visits_seq.nextval, 'admin', 'start', CURRENT_TIMESTAMP);
insert into visits(id, user_id, page_id, created) values(visits_seq.nextval, 'admin', 'home', CURRENT_TIMESTAMP);
insert into visits(id, user_id, page_id, created) values(visits_seq.nextval, 'admin', 'about', CURRENT_TIMESTAMP);
insert into visits(id, user_id, page_id, created) values(visits_seq.nextval, 'admin', 'logout', CURRENT_TIMESTAMP);
insert into visits(id, user_id, page_id, created) values(visits_seq.nextval, 'admin', 'info', CURRENT_TIMESTAMP);
insert into visits(id, user_id, page_id, created) values(visits_seq.nextval, 'admin', 'users', CURRENT_TIMESTAMP);
insert into visits(id, user_id, page_id, created) values(visits_seq.nextval, 'admin', 'contacts', CURRENT_TIMESTAMP);
insert into visits(id, user_id, page_id, created) values(visits_seq.nextval, 'admin', 'company', CURRENT_TIMESTAMP);
insert into visits(id, user_id, page_id, created) values(visits_seq.nextval, 'admin', 'main', CURRENT_TIMESTAMP);
insert into visits(id, user_id, page_id, created) values(visits_seq.nextval, 'admin','privacy', CURRENT_TIMESTAMP);
insert into visits(id, user_id, page_id, created) values(visits_seq.nextval, 'admin','products', CURRENT_TIMESTAMP);
insert into visits(id, user_id, page_id, created) values(visits_seq.nextval, 'user', 'start', CURRENT_TIMESTAMP);
insert into visits(id, user_id, page_id, created) values(visits_seq.nextval, 'user', 'about', CURRENT_TIMESTAMP);

