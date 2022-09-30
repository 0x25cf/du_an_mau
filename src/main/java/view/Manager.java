package view;

import model.Product;
import model.ProductColor;
import model.ProductDetail;
import repository.*;
import service.Inserter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class Manager extends JFrame{
    private JPanel content;
    private JTabbedPane tabbedPane1;
    private JTable data;
    private JTextField product_id;
    private JTextField product_name;
    private JComboBox product_color;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JComboBox producer;
    private JComboBox product_line;
    private JTable customer_product_view;

    private DefaultTableModel staff_model, customer_model;

    public Manager() {
        this.setContentPane(content);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(1000, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        data.setModel(new DefaultTableModel(
                new String[] {"ma", "ten", "mau", "nha san xuat", "dong san pham"},
                0
        ));

        customer_product_view.setModel(new DefaultTableModel(
                new String[] {"ma", "ten", "mau", "nha san xuat", "dong san pham"},
                0
        ));

        this.staff_model = (DefaultTableModel) data.getModel();
        this.customer_model = (DefaultTableModel) customer_product_view.getModel();

        addButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((new RepoProduct().findName(product_id.getText()))) {
                    new RepoProduct().insert(new Product(
                            product_id.getText(),
                            product_name.getText()
                    ));
                }
                new Repo<ProductDetail>().insert(
                    new ProductDetail(
                        new RepoProduct()
                                .findIdByName(product_name.getText()),
                        new RepoProductColor()
                                .findIdByName(product_color.getSelectedItem().toString()),
                        new RepoProducer()
                                .findIdByName(producer.getSelectedItem().toString()),
                        new RepoProductLine()
                                .findIdByName(product_line.getSelectedItem().toString())
                    )
                );
                fillTable();
            }
        });

        product_color.setModel(new DefaultComboBoxModel(
            new RepoProductColor().selectAllName()
        ));

        product_line.setModel(new DefaultComboBoxModel(
            new RepoProductLine().findAllName()
        ));

        producer.setModel(new DefaultComboBoxModel(
            new RepoProducer().findAllName()
        ));

        fillTable();
        product_id.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                product_name.setText(new RepoProduct().findNameById(product_id.getText() + e.getKeyChar()));
            }
        });
        data.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (data.getSelectedRowCount() == 1) {
                    var product_info = new RepoProductDetail().findAll().get(data.getSelectedRow());
                    product_id.setText(product_info.getProduct().getProductId());
                    product_name.setText(product_info.getProduct().getName());
                    product_color.setSelectedItem(product_info.getColor().getCode());
                    product_line.setSelectedItem(product_info.getProduct_line().getProductLineId());
                }
            }
        });
    }

    public void fillTable() {
        this.staff_model.setRowCount(0);
        for (ProductDetail i: new RepoProductDetail().findAll()) {
            this.staff_model.addRow(
                    i.toStrings()
            );
        }

        this.customer_model.setRowCount(0);
        for (ProductDetail i: new RepoProductDetail().findAll()) {
            this.customer_model.addRow(
                    i.toStrings()
            );
        }
    }
}
