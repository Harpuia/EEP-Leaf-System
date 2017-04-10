/**
 * ****************************************************************************
 * File:NewJFrame.java Course: 17655 Project: Assignment 2 Copyright: Copyright
 * (c) 2009 Carnegie Mellon University Versions: 1.0 November 2009 - Initial
 * rewrite of original assignment 2 (ajl).
 *
 * This class defines a GUI application that allows inventory to be added to the
 * inventory databases. There are tree tables in the inventory database: trees,
 * shrubs, and seeds.
 *
 *****************************************************************************
 */
/*
 * AddInventoryMainFrame.java
 *
 * Created on Jan 29, 2010, 9:24:23 PM
 */
/**
 *
 * @author lattanze
 */
public class InventoryMainFrame extends javax.swing.JFrame {
    private LoginWindow loginWindow;
    String versionID = "v2.10.10";

    /**
     * Creates new form AddInventoryMainFrame
     */
    public InventoryMainFrame() {
        initComponents();
        jLabel1.setText("Inventory Management Application " + versionID);
        
        loginWindow = new LoginWindow(this);
        loginWindow.setVisible(true);
        loginWindow.setModal(true);
        
        if(loginWindow.isSucceeded()) {
            setVisible(true);
        } else {
            System.exit(1);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jRadioBtBox = new javax.swing.JRadioButton();
        jRadioBtGenomics = new javax.swing.JRadioButton();
        jRadioBtProcess = new javax.swing.JRadioButton();
        jRadioBtRefMaterial = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jRadioButton1.setText("Trees");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Shrubs");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setText("Seeds");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("EEPs Inventory Management Application");

        jLabel2.setText("Product ID");

        jLabel3.setText("Price");

        jLabel4.setText("Quantity");

        jTextField1.setText("localhost");

        jButton1.setText("Add Item");
        jButton1.setActionCommand("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel5.setText("Product Description");

        jLabel6.setText("Database Server IP");

        jButton2.setText("List Inventory");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete Item");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Decrement");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setText("Deletes item selected from list ");

        jLabel8.setText("Decrements inventory count of item selected from the list");

        jRadioBtBox.setText("Culture Boxes");
        jRadioBtBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jRadioBtGenomics.setText("Genomics");
        jRadioBtGenomics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jRadioBtProcess.setText("Processing");
        jRadioBtProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioBtProcessActionPerformed(evt);
            }
        });

        jRadioBtRefMaterial.setText("Reference Materials");
        jRadioBtRefMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioBtRefMaterialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField4)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jRadioButton1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRadioBtBox))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jRadioButton3)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRadioBtGenomics)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioBtProcess))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton2)
                                        .addGap(10, 10, 10)
                                        .addComponent(jRadioBtRefMaterial)))
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 320, Short.MAX_VALUE))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(17, 17, 17)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(324, 324, 324)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton3)
                            .addComponent(jLabel3)
                            .addComponent(jRadioBtGenomics))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton2)
                            .addComponent(jLabel4)
                            .addComponent(jRadioBtRefMaterial)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jRadioBtBox))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton4))))
                    .addComponent(jRadioBtProcess))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private boolean hasSelectedType() {
        if (jRadioButton1.isSelected() || jRadioButton2.isSelected() || jRadioButton3.isSelected() || jRadioBtBox.isSelected() || jRadioBtGenomics.isSelected() || jRadioBtRefMaterial.isSelected() || jRadioBtProcess.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    private ItemType getSelectedType() {
        ItemType type = null;
        if (jRadioButton1.isSelected()) {
            type = ItemType.TREES;
        } else if (jRadioButton2.isSelected()) {
            type = ItemType.SHRUBS;
        } else if (jRadioButton3.isSelected()) {
            type = ItemType.SEEDS;
        } else if (jRadioBtBox.isSelected()) {
            type = ItemType.CULTUREBOXES;
        } else if (jRadioBtProcess.isSelected()) {
            type = ItemType.PROCESSING;
        } else if (jRadioBtGenomics.isSelected()) {
            type = ItemType.GENOMICS;
        } else if (jRadioBtRefMaterial.isSelected()) {
            type = ItemType.REFERENCE_MATERIALS;
        }
        return type;
    }
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        jRadioButton1.setSelected(true);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioBtBox.setSelected(false);
        jRadioBtGenomics.setSelected(false);
        jRadioBtProcess.setSelected(false);
        jRadioBtRefMaterial.setSelected(false);

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(true);
        jRadioBtBox.setSelected(false);
        jRadioBtGenomics.setSelected(false);
        jRadioBtProcess.setSelected(false);
        jRadioBtRefMaterial.setSelected(false);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(true);
        jRadioButton3.setSelected(false);
        jRadioBtBox.setSelected(false);
        jRadioBtGenomics.setSelected(false);
        jRadioBtProcess.setSelected(false);
        jRadioBtRefMaterial.setSelected(false);
    }//GEN-LAST:event_jRadioButton2ActionPerformed
    /**
     * Adds an item to the inventory
     *
     * @param evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean fieldError = false;
        jTextArea1.setText("");

        //Check to make sure a radio button is selected
        if (!hasSelectedType()) {
            fieldError = true;
            jTextArea1.append("\nMust select Tree, Seeds, or Shrubs radio button.");
        } else {

            //Make sure there is a product description
            if (jTextField5.getText().length() == 0) {
                fieldError = true;
                jTextArea1.append("\nMust enter a product description.");
            } else {

                //Make sure there is a product ID
                if (jTextField2.getText().length() == 0) {
                    fieldError = true;
                    jTextArea1.append("\nMust enter a product ID.");
                } else {
                    //Make sure there is a price
                    if (jTextField3.getText().length() == 0) {
                        fieldError = true;
                        jTextArea1.append("\nMust enter a product price.");
                    } else {
                        //Make sure quantity is specified
                        if (jTextField4.getText().length() == 0) {
                            fieldError = true;
                            jTextArea1.append("\nMust enter a product quantity.");
                        }
                    }
                }
            }
        }

        if (!fieldError) {
            //Capturing SQL Server IP
            String sqlServerIP = jTextField1.getText();

            // get the data from the text fields
            String description = jTextField5.getText();
            String productID = jTextField2.getText();
            float quantity = Float.parseFloat(jTextField4.getText());
            float perUnitCost = Float.parseFloat(jTextField3.getText());
            ItemType type = null;
            //Capturing item type
            type = getSelectedType();
            //Creating InventoryItem object
            InventoryItem item = new InventoryItem(type, productID, description, quantity, perUnitCost);
            InventoryBusinessLogic inventory = new InventoryBusinessLogic(sqlServerIP);
            inventory.addInventoryItem(item);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Displays inventory items from the database
     *
     * @param evt
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Boolean fieldError = true;
        String msgString = null;
        ItemType itemType = null;
        String sqlServerIP = jTextField1.getText();

        // Check to make sure a radio button is selected
        if (hasSelectedType()) {
            fieldError = false;
            itemType = getSelectedType();
        } else {
            msgString = "Must select one type via radio button, such as Trees, Shrubs, Processings.";
            jTextArea1.setText("\n" + msgString);
        }

        //Now, we try to connect to the inventory database.
        if (!fieldError) {
            //Clear the fields - they are not needed and may cause confusion
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
            jTextArea1.setText("");

            //Querying
            jTextArea1.setText("");
            InventoryBusinessLogic inventory = new InventoryBusinessLogic(sqlServerIP);

            //Displaying results
            jTextArea1.append(inventory.getInventoryItems(itemType));
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    /**
     * Deletes an inventory item
     *
     * @param evt
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        int beginIndex;                     // Parsing index
        int endIndex;                       // Parsing index
        String productID = null;            // Product ID pnemonic
        Boolean IndexNotFound;              // Flag indicating a string index was not found.
        String errString = null;            // String for displaying errors
        String inventorySelection = null;   // Inventory text string selected by user
        IndexNotFound = false;              // Flag indicating that a string index was not found
        String sqlServerIP = jTextField1.getText();

        // this is the selected line of text
        inventorySelection = jTextArea1.getSelectedText();

        // make sure the selection is not blank
        if (inventorySelection != null) {
            // get the product ID - here we get the leading index
            beginIndex = 0;
            endIndex = inventorySelection.indexOf(">>", beginIndex);

            if (endIndex < 0) {
                IndexNotFound = true;
            } else {
                beginIndex = endIndex + 2; //skip past ">>"                                
            }

            if (!IndexNotFound) {
                // Here we get the trailing index and parse out the productID
                endIndex = inventorySelection.indexOf(":", beginIndex);

                if (endIndex < 0) {
                    IndexNotFound = true;
                } else {
                    productID = inventorySelection.substring(beginIndex, endIndex);
                }
            }

            // Now we delete the inventory item indicated by the productID we
            // parsed out above from the indicated table.
            if (!IndexNotFound) {
                jTextArea1.setText("");
                jTextArea1.append("Deleting ProductID: " + productID);

                // if trees inventory selected
                ItemType itemType = null;
                itemType = getSelectedType();
                Integer executeUpdateVal = null;
                InventoryBusinessLogic inventory = new InventoryBusinessLogic(sqlServerIP);
                executeUpdateVal = inventory.deleteInventoryItem(productID, itemType, errString);
                if (executeUpdateVal > 0) {
                    // let the user know all went well
                    jTextArea1.append("\n\n" + productID + " deleted...");
                    jTextArea1.append("\n Number of items deleted: " + executeUpdateVal);
                } else {
                    errString = "\nProblem with delete:: " + errString;
                    jTextArea1.append(errString);
                }
            }
        } else {
            jTextArea1.setText("");
            jTextArea1.append("\nNo items selected...\nSELECT ENTIRE INVENTORY LINE TO ADD ITEM TO ORDER\n(TRIPLE CLICK ITEM LINE)");
        }
    }

    /**
     * Decrements the count of an inventory item
     *
     * @param evt
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int beginIndex;                     // Parsing index
        int endIndex;                       // Parsing index
        Boolean IndexNotFound;              // Flag indicating a string index was not found.
        String inventorySelection = null;   // Inventory text string selected by user
        IndexNotFound = false;              // Flag indicating that a string index was not found
        String productID = null;
        String sqlServerIP = jTextField1.getText();
        String log = null;

        // this is the selected line of text
        inventorySelection = jTextArea1.getSelectedText();

        // make sure the selection is not blank
        if (inventorySelection != null) {
            // get the product ID - here we get the leading index
            beginIndex = 0;
            endIndex = inventorySelection.indexOf(">>", beginIndex);

            if (endIndex < 0) {
                IndexNotFound = true;
            } else {
                beginIndex = endIndex + 2; //skip past ">>"
            }

            if (!IndexNotFound) {
                // Here we get the trailing index and parse out the productID
                endIndex = inventorySelection.indexOf(":", beginIndex);

                if (endIndex < 0) {
                    IndexNotFound = true;
                } else {
                    productID = inventorySelection.substring(beginIndex, endIndex);
                }
            }

            // Now we decrement the inventory count of the item indicated by the productID we
            // parsed out above from the indicated table.
            if (!IndexNotFound) {
                //If there is no connection error, then we form the SQL statement
                //to decrement the inventory item count and then execute it.
                ItemType itemType = null;
                itemType = getSelectedType();
                InventoryBusinessLogic inventory = new InventoryBusinessLogic(sqlServerIP);
                inventory.decrementInventoryItem(productID, itemType, log);
                jTextArea1.setText(log);
            } else {
                jTextArea1.setText("");
                jTextArea1.append("\nNo items selected...\nSELECT ENTIRE INVENTORY LINE TO ADD ITEM TO ORDER\n(TRIPLE CLICK ITEM LINE)");
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    /**
     * Set selected to correspond type radio button
     *
     * @param evt
     */
    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        jRadioBtBox.setSelected(true);
        jRadioBtGenomics.setSelected(false);
        jRadioBtProcess.setSelected(false);
        jRadioBtRefMaterial.setSelected(false);
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
    }//GEN-LAST:event_jRadioButton4ActionPerformed
    //Set selected to correspond type radio button
    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        jRadioBtBox.setSelected(false);
        jRadioBtGenomics.setSelected(true);
        jRadioBtProcess.setSelected(false);
        jRadioBtRefMaterial.setSelected(false);
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
    }//GEN-LAST:event_jRadioButton5ActionPerformed
    //Set selected to correspond type radio button
    private void jRadioBtRefMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioBtRefMaterialActionPerformed
        jRadioBtBox.setSelected(false);
        jRadioBtGenomics.setSelected(false);
        jRadioBtProcess.setSelected(false);
        jRadioBtRefMaterial.setSelected(true);
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
    }//GEN-LAST:event_jRadioBtRefMaterialActionPerformed
    //Set selected to correspond type radio button
    private void jRadioBtProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioBtProcessActionPerformed
        jRadioBtBox.setSelected(false);
        jRadioBtGenomics.setSelected(false);
        jRadioBtProcess.setSelected(true);
        jRadioBtRefMaterial.setSelected(false);
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
    }//GEN-LAST:event_jRadioBtProcessActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        String log = null;
        UserManagementBusinessLogic userBL = loginWindow.userBL;
        boolean response = userBL.logout(log);
        if(response == false) {
            System.out.println(log);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * main entry of the application
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventoryMainFrame();                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioBtBox;
    private javax.swing.JRadioButton jRadioBtGenomics;
    private javax.swing.JRadioButton jRadioBtProcess;
    private javax.swing.JRadioButton jRadioBtRefMaterial;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables

}
