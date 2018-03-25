CREATE DATABASE clinic;

CREATE TABLE breeds (
  id          SERIAL PRIMARY KEY,
  name        VARCHAR(255) UNIQUE NOT NULL,
  pet_type_id INTEGER             NOT NULL,
  FOREIGN KEY (pet_type_id) REFERENCES pet_type (id)
);

CREATE TABLE images (
  id        SERIAL PRIMARY KEY,
  name      VARCHAR(255) NOT NULL,
  image_url VARCHAR(255) NOT NULL
);

CREATE TABLE roles (
  id   SERIAL PRIMARY KEY,
  role VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE users (
  id           SERIAL PRIMARY KEY,
  first_name   VARCHAR(255)        NOT NULL,
  last_name    VARCHAR(255)        NOT NULL,
  email        VARCHAR(255) UNIQUE NOT NULL,
  password     VARCHAR(255)        NOT NULL,
  phone_number VARCHAR(30)         NOT NULL
);

CREATE TABLE user_role (
  id      SERIAL PRIMARY KEY,
  user_id INTEGER NOT NULL,
  role_id INTEGER NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
);

CREATE TABLE pet_type (
  id   SERIAL PRIMARY KEY,
  type VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE pets (
  id          SERIAL PRIMARY KEY,
  name        VARCHAR(100) NOT NULL,
  age         INTEGER      NOT NULL,
  weight      FLOAT        NOT NULL,
  pet_type_id INTEGER      NOT NULL,
  breed_id    INTEGER      NOT NULL,
  owner_id    INTEGER      NOT NULL,
  image_id    INTEGER      NOT NULL,

  FOREIGN KEY (pet_type_id) REFERENCES pet_type (id),
  FOREIGN KEY (breed_id) REFERENCES breeds (id),
  FOREIGN KEY (owner_id) REFERENCES users (id),
  FOREIGN KEY (image_id) REFERENCES images (id)
);


CREATE TABLE services (
  id          SERIAL PRIMARY KEY,
  name        VARCHAR(255)  NOT NULL,
  description VARCHAR(2000) NOT NULL,
  price       INTEGER       NOT NULL,
  date        TIMESTAMP     NOT NULL,
  image_id    INTEGER       NOT NULL DEFAULT 0
);

CREATE TABLE pet_service (
  id         SERIAL PRIMARY KEY,
  pet_id     INTEGER NOT NULL,
  service_id INTEGER NOT NULL,

  FOREIGN KEY (pet_id) REFERENCES pets (id),
  FOREIGN KEY (service_id) REFERENCES services (id)
);

-- insert role table
INSERT INTO roles (role) VALUES ('user');
INSERT INTO roles (role) VALUES ('admin');

-- insert pet type
INSERT INTO pet_type (type) VALUES ('собака');
INSERT INTO pet_type (type) VALUES ('кошка');

-- insert breed
INSERT INTO breeds (name, pet_type_id) VALUES ('Австралийская овчарка', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Американский бульдог', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Американский питбультерьер', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Американский стаффордширский терьер', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Английский бульдог', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Английский коккер-спаниель', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Английский мастиф', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Английский сеттер', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Аргентинский дог', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Афганская борзая', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Басенджи', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Бассет хаунд', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Бельгийская овчарка', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Бигль', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Бобтейл', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Боксер', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Бордер колли', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Бульмастиф', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Бультерьер', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Восточносибирская лайка', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Восточноевропейская овчарка', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Далматин', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Джек-рассел-терьер', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Доберман', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Золотистый ретривер', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Кавказская овчарка', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Колли', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Лабрадор-ретривер', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Мопс', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Московская сторожевая', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Немецкая овчарка', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Немецкий дог', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Немецкий шпиц', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Ньюфаундленд', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Пекинес', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Пудель', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Ризеншнауцер', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Ротвейлер', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Русская гончая', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Сенбернар', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Такса', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Тибетский мастиф', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Фокстерьер', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Французский бульдог', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Чау-чау', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Черный терьер', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Чихуахуа', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Шарпей', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Шотландский сеттер', 1);
INSERT INTO breeds (name, pet_type_id) VALUES ('Абиссинская', 2);
INSERT INTO breeds (name, pet_type_id) VALUES ('Австралийская дымчатая', 2);
INSERT INTO breeds (name, pet_type_id) VALUES ('Азиатская табби', 2);
INSERT INTO breeds (name, pet_type_id) VALUES ('Американская жесткошерстная', 2);
INSERT INTO breeds (name, pet_type_id) VALUES ('Американский бобтейл', 2);
INSERT INTO breeds (name, pet_type_id) VALUES ('Американский керл', 2);
INSERT INTO breeds (name, pet_type_id) VALUES ('Балинезийская', 2);
INSERT INTO breeds (name, pet_type_id) VALUES ('Бенгальская', 2);
INSERT INTO breeds (name, pet_type_id) VALUES ('Британская короткошерстная', 2);
INSERT INTO breeds (name, pet_type_id) VALUES ('Бурманская', 2);
INSERT INTO breeds (name, pet_type_id) VALUES ('Бурмилла длинношерстная', 2);
INSERT INTO breeds (name, pet_type_id) VALUES ('Норвежская лесная', 2);
INSERT INTO breeds (name, pet_type_id) VALUES ('Персидская', 2);
INSERT INTO breeds (name, pet_type_id) VALUES ('Русская голубая', 2);
INSERT INTO breeds (name, pet_type_id) VALUES ('Саванна', 2);
INSERT INTO breeds (name, pet_type_id) VALUES ('Сиамская', 2);
INSERT INTO breeds (name, pet_type_id) VALUES ('Сибирская', 2);
INSERT INTO breeds (name, pet_type_id) VALUES ('Сингапурская', 2);
INSERT INTO breeds (name, pet_type_id) VALUES ('Тайская', 2);
INSERT INTO breeds (name, pet_type_id) VALUES ('Турецкая ангора', 2);
INSERT INTO breeds (name, pet_type_id) VALUES ('Украинский левкой', 2);
INSERT INTO breeds (name, pet_type_id) VALUES ('Уральский рекс', 2);

INSERT INTO services (name, description, price, date) VALUES ('Рентген',
                                                              'Рентгенологическое исследование - позволяет оценить структурно-морфологическое состояние органов и тканей животного организма.

 Рентгенография – методика рентгенологического исследования, при которой получают фиксированное изображение объекта (органов и тканей). Рентгеновский снимок отображает состояние органа или ткани только в момент съемки, и он является объективным документом, который можно изучать неограниченно долгое время. Повторное рентгенологическое исследование позволяет оценить динамику  развития патологического процесса.
 Рентгенография помогает ветеринарному врачу:

 Распознать причину и степень опасного состояния;
 Дифференцировать наиболее серьёзное состояние для немедленного лечения, когда присутствуют многочисленные повреждения;
 Пересмотреть эффективность неотложной терапии;
 Отследить динамику состояния пациента.', 3000, now());

INSERT INTO services (name, description, price, date) VALUES ('Вакцинация', 'Вакцинация или прививка – введение различных антигенных материалов в организм питомца с целью выработки адекватного иммунитета в случае соприкосновения с носителем болезни. Не стоит надеяться, что это лишняя процедура, если Ваш питомец исключительно домашний и на улицу не выходит. Часто владельцы, сами того не зная, приносят вирусы и бактерии на одежде, обуви или даже коже, увеличивая риск заражения. В этом случае вакцинация кошки или собаки, хорьков и других домашних животных позволит значительно снизить риски заражения. Тем более, что для домашних животных, не привыкших к улице, это дополнительный стресс.
Прививки не стоит проводить если:
повышенная температура тела;
ослабленный организм;
за 14 дней до родов и после;
в течение 14 дней после завершения курса иммуносупрессоров или антибиотиков;
если в течение 21 дня до или после вакцинации запланирована хирургическая операция, например, стерилизация питомца.',
                                                              1000, now());

INSERT INTO services (name, description, price, date) VALUES ('Чипирование', 'Система чипирования животных состоит из трех составляющих: микрочипа, который является носителем уникального цифрового кода, сканера для считывания этого кода и базы данных.

Процесс чипирования представляет собой подкожную инъекцию в область холки, что является безопасной и безболезненной процедурой для животного. В течение нескольких дней чип покрывается соединительнотканной капсулой и становится частью подкожной жировой клетчатки, что препятствует его смещению.

Несмотря на то, что микрочип является инородным телом в организме животного, при правильно выполненной инъекции реакции отторжения не происходит за счет биосовместимого стекла на поверхности чипа. После введения микрочипа на его цифровой код в международную базу данных отправляется информация не только о самом животном (вид, порода, дата рождения, кличка), но и о владельце. Считывание данных производится с помощью сканера, который имеется в любой крупной ветеринарной клинике.',
                                                              1500, now());
