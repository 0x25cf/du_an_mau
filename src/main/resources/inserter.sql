USE FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041
                
select *from chitietsp

INSERT INTO SanPham (ma, Ten)
VALUES
    ('P001', 'giày adidas'),
    ('P002', 'giày New Balance'),
    ('P003', 'giày Vans')

GO
INSERT INTO NSX (ma, ten)
VALUES
    ('NSX001', 'Adidas'),
    ('NSX002', 'New Balance'),
    ('NSX003', 'Vans')
GO
INSERT INTO MauSac (ma, ten)
VALUES
    ('COLOR001', 'White'),
    ('COLOR002', 'Black'),
    ('COLOR003', 'Bron')


INSERT INTO DongSP (ma, ten)
VALUES
    ('PL001', 'Nomal'),
    ('PL002', 'Pro'),
    ('PL003', 'VIP')

SELECT * FROM ChiTietSP
SELECT * from MauSac
SELECT * FROM NSX
select * from SanPham
select * from DongSP
