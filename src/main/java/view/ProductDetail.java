package view;

import repository.RepoProducer;
import repository.RepoProduct;
import repository.RepoProductColor;
import repository.RepoProductLine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductDetail extends JDialog {
    private JComboBox product_id;
    private JComboBox product_name;
    private JButton addButton;
    private JPanel content;
    private JComboBox product_color;
    private JComboBox producer;
    private JComboBox product_line;
    private JButton add_button;

    private model.ProductDetail product;

    public ProductDetail(model.ProductDetail p) {
        product = p;
        this.setContentPane(content);
        this.setResizable(false);
        this.pack();
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);


        product_id.setSelectedItem(product.getProduct().getProductId());
        product_name.setSelectedItem(product.getProduct().getName());
        product_color.setSelectedItem(product.getColor().getCode());
        product_line.setSelectedItem(product.getProduct_line().getProductLineId());

        product_color.setModel(new DefaultComboBoxModel(
                new RepoProductColor().findAllName()
        ));

        product_line.setModel(new DefaultComboBoxModel(
                new RepoProductLine().findAllName()
        ));

        producer.setModel(new DefaultComboBoxModel(
                new RepoProducer().findAllName()
        ));

        product_id.setModel(new DefaultComboBoxModel(
                new RepoProduct().findAllProductId().toArray(new String[0])
        ));

        product_name.setModel(new DefaultComboBoxModel(
                new RepoProduct().findAllProductName().toArray(new String[0])
        ));

        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    public model.ProductDetail update () {
        product.setProductId(product_id.getSelectedItem().toString());
        product.setProductColorId(new RepoProductColor().findIdByName(product_color.getSelectedItem().toString()));
        product.setProducerId(new RepoProducer().findIdByName(producer.getSelectedItem().toString()));
        product.setProductLineId(new RepoProductLine().findIdByName(product_line.getSelectedItem().toString()));
        return this.product;
    }
}
