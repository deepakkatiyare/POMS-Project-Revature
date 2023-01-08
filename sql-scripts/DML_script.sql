-- DML SCRIPT
 
-- Inserting values into pizza table
INSERT INTO pizza(pizza_type,pizza_size,pizza_category,pizza_price) VALUES
("mozerrella chilli paneer pizza","regular","veg",100),
("mozerrella chilli paneer pizza","medium","veg",125),
("mozerrella chilli paneer pizza","large","veg",150),

("jalapeno chilli paneer pizza","regular","veg",110),
("jalapeno chilli paneer pizza","medium","veg",130),
("jalapeno chilli paneer pizza","large","veg",160),

("Black Olives chilli paneer pizza","regular","veg",125),
("Black Olives chilli paneer pizza","medium","veg",150),
("Black Olives chilli paneer pizza","large","veg",200),

("Extra Cheese chilli paneer pizza","regular","veg",150),
("Extra Cheese chilli paneer pizza","medium","veg",180),
("Extra Cheese chilli paneer pizza","large","veg",220),




-- 2nd variety of pizza
("mozerrella Mexican Green Wave","regular","veg",125),
("mozerrella Mexican Green Wave","medium","veg",150),
("mozerrella Mexican Green Wave","large","veg",200),

("jalapeno Mexican Green Wave","regular","veg",140),
("jalapeno Mexican Green Wave","medium","veg",180),
("jalapeno Mexican Green Wave","large","veg",250),

("Black Olives Mexican Green Wave","regular","veg",150),
("Black Olives Mexican Green Wave","medium","veg",200),
("Black Olives Mexican Green Wave","large","veg",250),

("Extra Cheese Mexican Green Wave","regular","veg",200),
("Extra Cheese Mexican Green Wave","medium","veg",250),
("Extra Cheese Mexican Green Wave","large","veg",300),


-- 3rd entry

("mozerrella Veggie paradise","regular","veg",225),
("mozerrella Veggie paradise","medium","veg",275),
("mozerrella Veggie paradise","large","veg",325),

("jalapeno Veggie paradise","regular","veg",240),
("jalapeno Veggie paradise","medium","veg",300),
("jalapeno Veggie paradise","large","veg",360),

("Black Olives Veggie paradise","regular","veg",250),
("Black Olives Veggie paradise paradise","medium","veg",320),
("Black Olives Veggie paradise paradise","large","veg",380),

("Extra Cheese Veggie paradise paradise","regular","veg",300),
("Extra Cheese Veggie paradise paradise","medium","veg",350),
("Extra Cheese Veggie paradise","large","veg",400),


-- 4th entry

("mozerrella Veg Exotic","regular","veg",320),
("mozerrella Veg Exotic","medium","veg",360),
("mozerrella Veg Exotic","large","veg",400),

("jalapeno Veg Exotic","regular","veg",340),
("jalapeno Veg Exotic","medium","veg",380),
("jalapeno Veg Exotic","large","veg",420),

("Black Olives Veg Exotic","regular","veg",375),
("Black Olives Veg Exotic","medium","veg",410),
("Black Olives Veg Exotic","large","veg",450),

("Extra Cheese Veg Exotic","regular","veg",400),
("Extra Cheese Veg Exotic","medium","veg",450),
("Extra Cheese Veg Exotic","large","veg",500),


-- non veg entry


("mozerrella Peri-Peri Chicken","regular","non-veg",200),
("mozerrella Peri-Peri Chicken","medium","non-veg",250),
("mozerrella Peri-Peri Chicken","large","non-veg",300),

("jalapeno Peri-Peri Chicken","regular","non-veg",225),
("jalapeno Peri-Peri Chicken","medium","non-veg",275),
("jalapeno Peri-Peri Chicken","large","non-veg",325),

("Black Olives Peri-Peri Chicken","regular","non-veg",250),
("Black Olives Peri-Peri Chicken","medium","non-veg",300),
("Black Olives Peri-Peri Chicken","large","non-veg",350),

("Extra Cheese Peri-Peri Chicken","regular","non-veg",275),
("Extra Cheese Peri-Peri Chicken","medium","non-veg",320),
("Extra Cheese Peri-Peri Chicken","large","non-veg",360),

-- 2nd non veg entry


("mozerrella Chicken Fiesta","regular","non-veg",250),
("mozerrella Chicken Fiesta","medium","non-veg",300),
("mozerrella Chicken Fiesta","large","non-veg",350),

("jalapeno Chicken Fiesta","regular","non-veg",280),
("jalapeno Chicken Fiesta","medium","non-veg",320),
("jalapeno Chicken Fiesta","large","non-veg",360),

("Black Olives Chicken Fiesta","regular","non-veg",320),
("Black Olives Chicken Fiesta","medium","non-veg",360),
("Black Olives Chicken Fiesta","large","non-veg",400),

("Extra Cheese Chicken Fiesta","regular","non-veg",350),
("Extra Cheese Chicken Fiesta","medium","non-veg",400),
("Extra Cheese Chicken Fiesta","large","non-veg",450),

-- 3rd non veg entry

("mozerrella Smoked Chicken","regular","non-veg",400),
("mozerrella Smoked Chicken","medium","non-veg",450),
("mozerrella Smoked Chicken","large","non-veg",500),

("jalapeno Smoked Chicken","regular","non-veg",425),
("jalapeno Smoked Chicken","medium","non-veg",475),
("jalapeno Smoked Chicken","large","non-veg",525),

("Black Olives Smoked Chicken","regular","non-veg",450),
("Black Olives Smoked Chicken","medium","non-veg",500),
("Black Olives Smoked Chicken","large","non-veg",550),

("Extra Cheese Smoked Chicken","regular","non-veg",500),
("Extra Cheese Smoked Chicken","medium","non-veg",550),
("Extra Cheese Smoked Chicken","large","non-veg",600),


-- 4th entry

("mozerrella Chicken Exotic","regular","non-veg",450),
("mozerrella Chicken Exotic","medium","non-veg",500),
("mozerrella Chicken Exotic","large","non-veg",550),

("jalapeno Chicken Exotic","regular","non-veg",500),
("jalapeno Chicken Exotic","medium","non-veg",550),
("jalapeno Chicken Exotic","large","non-veg",600),

("Black Olives Chicken Exotic","regular","non-veg",550),
("Black Olives Chicken Exotic","medium","non-veg",600),
("Black Olives Chicken Exotic","large","non-veg",650),

("Extra Cheese Chicken Exotic","regular","non-veg",600),
("Extra Cheese Chicken Exotic","medium","non-veg",660),
("Extra Cheese Chicken Exotic","large","non-veg",720);




-- Inserting values into beverage table

INSERT INTO beverage(b_name,b_type,b_price) VALUES 
("tea","hot",20),
("coffee","hot",30),
("Hot Choclate","hot",50),

("sprite","cold",25),
("coke","cold",30),
("Pepsi","cold",35),
("Thumbsup","cold",40),
("latte","cold",60);

-- Inserting values into cookie table

INSERT INTO cookie(cookie_name,cookie_price) VALUES
("oreo cookies",25),
("Butter cookies",30),
("Macaron cookies",40),
("Biscotti cookies",50),
("Gingerbread cookies",60),
("Choco chip cookies",80),
("Oatmeal Raisin cookies",100);



