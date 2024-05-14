create table department
(
    id                 int auto_increment
        primary key,
    `department-title` varchar(255) null,
    year_of_found      int          null
);

create table instructor
(
    id            int auto_increment
        primary key,
    first_name    varchar(255) null,
    last_name     varchar(255) null,
    gender        varchar(255) null,
    date_of_birth datetime     null,
    email         varchar(255) null,
    telephone     varchar(255) null,
    address       varchar(255) null,
    department_id int          null,
    instructor_id int          null,
    constraint FK_INSTRUCTOR_ON_DEPARTMENT
        foreign key (department_id) references department (id),
    constraint FK_INSTRUCTOR_ON_INSTRUCTOR
        foreign key (instructor_id) references department (id),
    constraint FKpk9ufdquofu3g1wmao4oh1wgo
        foreign key (department_id) references department (id),
    constraint FKr3jdx1h6etax8wsf8av5n65yi
        foreign key (instructor_id) references department (id)
);

create table course
(
    id            int auto_increment
        primary key,
    code          varchar(255) null,
    course_title  varchar(255) null,
    max_capacity  int          null,
    credit        int          null,
    course_level  varchar(255) null,
    department_id int          null,
    instructor_id int          null,
    course_id     int          null,
    constraint FK_COURSE_ON_COURSE
        foreign key (course_id) references department (id),
    constraint FK_COURSE_ON_DEPARTMENT
        foreign key (department_id) references department (id),
    constraint FK_COURSE_ON_INSTRUCTOR
        foreign key (instructor_id) references instructor (id),
    constraint FKi1btm7ma8n3gaj6afdno300wm
        foreign key (department_id) references department (id),
    constraint FKkr3g25it0lxyj8msocvengprg
        foreign key (course_id) references department (id),
    constraint FKqk2yq2yk124dhlsilomy36qr9
        foreign key (instructor_id) references instructor (id)
);

create table program
(
    id            int auto_increment
        primary key,
    program_title varchar(255) null,
    program_type  varchar(255) null,
    duration      varchar(255) null,
    credit        int          null,
    department_id int          null,
    program_id    int          null,
    constraint FK_PROGRAM_ON_DEPARTMENT
        foreign key (department_id) references department (id),
    constraint FK_PROGRAM_ON_PROGRAM
        foreign key (program_id) references department (id),
    constraint FK2on4te9hk4wan3lig1hqcwrl9
        foreign key (program_id) references department (id),
    constraint FKbx2a0ta1c2ppgqcm9fa1ufftf
        foreign key (department_id) references department (id)
);

create table student
(
    department_id     int          null,
    id                int auto_increment
        primary key,
    program_id        int          null,
    student_id        int          null,
    year_of_entry     int          null,
    year_of_limit     int          null,
    date_of_birth     datetime(6)  null,
    address           varchar(255) null,
    country_of_origin varchar(255) null,
    email             varchar(255) null,
    first_name        varchar(255) null,
    gender            varchar(255) null,
    last_name         varchar(255) null,
    student_type      varchar(255) null,
    telephone         varchar(255) null,
    constraint FK9q4a7kjt0lk789n6orxc0xsf9
        foreign key (program_id) references program (id),
    constraint FKkh3m8c2tq2tgrgma1iyn7tvmx
        foreign key (department_id) references department (id),
    constraint FKn1652ukl32n4ewviv9s5si5ul
        foreign key (student_id) references department (id)
);

create table course_student
(
    course_id  int not null,
    student_id int not null,
    constraint FK4xxxkt1m6afc9vxp3ryb0xfhi
        foreign key (student_id) references student (id),
    constraint FKlmj50qx9k98b7li5li74nnylb
        foreign key (course_id) references course (id)
);

create table program_students
(
    program_id  int not null,
    students_id int not null,
    constraint UK_prbk038o8o6qnih3ce5di9806
        unique (students_id),
    constraint FK1tca3hbhm19ofl7yvc3sljm07
        foreign key (students_id) references student (id),
    constraint FKt66t8ndphtn6jpk3ofjx7knom
        foreign key (program_id) references program (id)
);

