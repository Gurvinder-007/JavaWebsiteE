DROP TABLE IF EXISTS Categories;
DROP TABLE IF EXISTS Listings;

CREATE TABLE Categories (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE Listings (
    listing_id INT AUTO_INCREMENT PRIMARY KEY,
    item_name VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL,
    condition VARCHAR(50) NOT NULL,
    photo_url VARCHAR(255),
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES Categories(category_id)
);

INSERT INTO Categories (name) VALUES
('Electronics'),
('Clothing'),
('Furniture');

INSERT INTO Listings (item_name, description, condition, photo_url, category_id) VALUES
('iPhone X', 'Brand: Apple, RAM: 8GB, Model: iPhone X, Colour: Silver', 'Good', NULL, 1),
('Top', 'Brand: Nike, Size: Large, Colour: Black', 'New', NULL, 2),
('IKEA Sofa', 'Brand: IKEA, Type: Sofa, Colour: Brown', 'Used', NULL, 3),
('Console', 'Brand: Sony, Colour: gold, Model: Play Station 5', 'New', NULL, 1),
('IKEA Bookcase', 'Brand: IKEA, Type: Bookcase, Colour: white', 'Used', NULL, 3),
('Shoes', 'Brand: Nike, Size: 7, Colour: blue', 'New', NULL, 2),
('Jacket', 'Brand: Next, Size: Medium, Colour: blue', 'New', NULL, 2),
('DFS Chair', 'Brand: DFS, Type: chair, Colour: white', 'Used', NULL, 3),
('Air Pods', 'Brand: Apple, Colour: white', 'New', NULL, 1),
('Samsung S20', 'Brand: Samsung, RAM: 6GB, Model: S20, Colour: green', 'New', NULL, 1),
('Samsung S10', 'Brand: Samsung, RAM: 3GB, Model: S10, Colour: black', 'Used', NULL, 1);
