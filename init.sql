create table tbl_User(
  user_id varchar(16) primary key,
  user_name varchar(16) not null,
  password varchar(64) not null,
  identity int not null comment '1是老师，2是学生'
) charset = utf8 comment '用户表';

create table tbl_Class(

  class_id int auto_increment primary key
         comment '作为选择班级的唯一标示',
  students_num int default 0 comment '学生人数',
  class_name varchar(32) not null comment '班级名字',
  teacher_id varchar(16) not null comment '教师工号',
  class_icon varchar(256) default 'http://oukrdttii.bkt.clouddn.com/18-6-24/60283894.jpg'
) charset = utf8 comment '班级表';

create table tbl_ClassStudents(
  id int auto_increment primary key comment '仅仅作为主键无实际用处',
  class_id varchar(16) not null comment '班级id',
  student_id varchar(16) not null comment '学生学号',
  student_name varchar(16) not null comment '学生姓名'
) charset = utf8 comment '班级成员表';


create table tbl_Paper(
  paper_id int primary key auto_increment
        comment '作为主键和试卷题目表唯一标识',
  teacher_id varchar(16) not null comment '老师工号',
  paper_name varchar(16) not null comment '试卷名字',
  proble_num int not null comment '试卷总题目数，为了算正确率',
  paper_score int comment '试卷的总分数'
) charset = utf8 comment '试卷表';

create table tbl_PaperProblems(
  problem_id int primary key auto_increment
          comment '作为主键，学生提交题目的唯一标识',
  paper_id int not null comment '题目对应哪张试卷',
  problem_content varchar(512) not null comment '题目',
  problem_type int not null
  comment '题目的类型，1是单选，2是多选，3是判断，4是填空',
  question_a varchar(64) comment '如果是选择题，那么这就是选项A',
  question_b varchar(64) comment '如果是选择题，那么这就是选项B',
  question_c varchar(64) comment '如果是选择题，那么这就是选项C',
  question_d varchar(64) comment '如果是选择题，那么这就是选项D',
  choice_num int default 0 comment '如果是选择题，选择题的选项个数',
  right_answer varchar(32)
            comment '问题正确答案,如果类型是判断题，1对2错'
) charset = utf8 comment '试卷题目表';


create table tbl_PaperForClass(
  id int auto_increment primary key comment '仅仅作为主键无实际用处',
  papper_id int not null comment '试卷id',
  class_id int not null comment '班级id',
  teacher_id varchar(16) not null comment '教师工号',
  deadline timestamp default current_timestamp
        comment '试卷提交最晚日期',
  start_time timestamp default current_timestamp
        comment '试卷发布时间',
  limit_time varchar(16) comment '试卷限时'
) charset = utf8 comment '试卷发布到哪个班级';

create table tbl_StudentsPaper(
  students_paper_id int auto_increment primary key
        comment '用来作为学生试卷问题标识试卷的唯一凭证',
  papper_id int not null comment '试卷id',
  student_id varchar(16) not null comment '学生学号',
  student_name varchar(16) not null comment '学生姓名',
  student_score int not null comment '学生得分',
  correct_rate varchar(8) not null comment '学生试卷正确率',
  is_submit int not null comment '是否提交1提交，2没有提交',
  submit_time timestamp default current_timestamp
          comment '学生提交试卷的时间'
) charset = utf8 comment '学生提交的试卷';


create table tbl_StudentsAnswer(
  id int auto_increment primary key comment '仅仅作为主键无实际用处',
  paper_id int not null comment '标识是学生做的哪张试卷',
  students_answer varchar(32) not null comment '问题答案,如果类型是判断题，1对2错',
  problem_id int not null comment '标识是哪个题目',
  student_id varchar(16) comment '知道是哪个题目',
  problem_type int not null
  comment '题目的类型，1是单选，2是多选，3是判断，4是填空',
  is_right int not null comment '是否正确'

) charset = utf8 comment '学生做的试卷的题目';

create table tbl_Notice(
  id int auto_increment primary key comment '仅仅作为主键无实际用处',
  teacher_id varchar(16) not null comment '教师工号',
  class_name varchar(32) not null comment '班级名字',
  title varchar(32) not null comment '通知标题',
  content varchar(1024)  comment '通知内容',
  overview varchar(256) not null comment '从通知内容截取前两百字',
  image varchar(512) comment '图片链接',
  publish_time timestamp default current_timestamp
          comment '发布公告时间'
) charset = utf8 comment '通知栏';


