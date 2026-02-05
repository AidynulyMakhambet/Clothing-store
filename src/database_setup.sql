-- drop all tables at start
DROP TABLE IF EXISTS clothingItems;

CREATE TABLE clothingItems (
                       clothing_item_id SERIAL PRIMARY KEY,
                       clothingItemId VARCHAR(100) UNIQUE NOT NULL,
                       name VARCHAR(100) NOT NULL,
                       brand VARCHAR(100) NOT NULL,
                       size VARCHAR(100) NOT NULL,
                       color VARCHAR(100) NOT NULL,
                       price DECIMAL(10, 2) NOT NULL,
                       stockQuantity INT NOT NULL,

    -- Type: 'PANTS' or 'SHIRT' (we removed generic ClothingItem since it's abstract)
                       clothing_item_type VARCHAR(20) NOT NULL CHECK (clothing_item_type IN ('PANTS', 'SHIRT')),

    -- Pants-specific field
                       hasBeltLoops BOOLEAN DEFAULT FALSE, -- FALSE if SHIRT
    -- Shirt-specific field
                       sleeveType VARCHAR(100) -- NULL if PANTS
);

-- Add indexes for better performance
CREATE INDEX idx_clothing_item_type ON clothingItems(clothing_item_type);
CREATE INDEX idx_clothing_item_name ON clothingItems(name);

-- ================================================
-- Insert Test Data (from Week 6)
-- ================================================

-- Test pants
INSERT INTO clothingItems (clothingItemId, name, color, size, price, stockQuantity, brand, clothing_item_type, hasBeltLoops, sleeveType)
VALUES
    ('1','Pants by KZ', 'red', 'M', 5000, 10, 'KZ', 'PANTS', true, NULL),
    ('2','Pants by USA', 'yellow', 'L', 3000, 3,'USA', 'PANTS', false, NULL);

-- Test shirts
INSERT INTO clothingItems (clothingItemId, name, color, size, price, stockQuantity, brand, clothing_item_type, hasBeltLoops, sleeveType)
VALUES
    ('3','Shirt by GUCCI', 'green', 'L', 10000, 3, 'GUCCI', 'SHIRT',false, 'short'),
    ('4','Shirt by KZ', 'blue', 'L', 5000, 10, 'KZ', 'SHIRT',false, 'long');
-- ================================================
-- Verify Data
-- ================================================

SELECT * FROM clothingItems ORDER BY clothing_item_id;

-- ================================================
-- USEFUL QUERIES FOR TESTING
-- ================================================

-- Count all clothingItems
SELECT COUNT(*) as total_items FROM clothingItems;

-- Get only Shirts
SELECT * FROM clothingItems WHERE clothing_item_type = 'SHIRT';

-- Get only Pants
SELECT * FROM clothingItems WHERE clothing_item_type = 'PANTS';

-- Get high-cost clothingItems(cost > 2500)
SELECT * FROM clothingItems WHERE price > 2500 ORDER BY price DESC;

-- Average cost by type
SELECT clothing_item_type, AVG(price) as avg_price, COUNT(*) as count
FROM clothingItems
GROUP BY clothing_item_type;


