package view;

import model.Product;
import model.ProductColor;
import model.ProductDetail;
import repository.*;
import service.Inserter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
            /**
             * Invoked when a key has been pressed.
             *
             * @param e
             */
            @Override
            public void keyPressed(KeyEvent e) {
                var pro = new RepoProduct().findById(product_id.getText() + e.getKeyChar());
                if (!pro.isEmpty()) {
                    product_name.setText(pro.get(0).getName());
                    product_name.setEditable(false);
                } else {
                    product_name.setEditable(true);
                    product_name.setText("");
                }
            }
        });
    }

    public void fillTable() {
        this.staff_model.setRowCount(0);
        for (ProductDetail i: new RepoProductDetail().selectAll()) {
            this.staff_model.addRow(
                    i.toStrings()
            );
        }

        this.customer_model.setRowCount(0);
        for (ProductDetail i: new RepoProductDetail().selectAll()) {
            this.customer_model.addRow(
                    i.toStrings()
            );
        }
    }
}
