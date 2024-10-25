INSERT INTO CATEGORIES (NAME) VALUES
('étel'),
('használati tárgyak'),
('öltözet'),
('tudományos');


INSERT INTO ITEMS (NAME, MIN_PRICE, MAX_PRICE, CATEGORY_ID) VALUES
  ('alma', 1, 3, 1),
  ('bögre', 5, 15, 2),
  ('100 oldalas könyv', 2, 5, 4),
  ('penna', 0, 2, 4),
  ('hátizsák', 20, 50, 2),
  ('sapka', 15, 80, 3),
  ('köpeny', 10, 25, 3);