/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package taylor;

import java.awt.Graphics;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Shreyas
 */
public class Window extends javax.swing.JFrame {
    
    private Calculator calc;
    
    /**
     * Creates new form Window
     */
    public Window() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException| UnsupportedLookAndFeelException e) {
            System.out.println("Error loading look and feel: " + e);
        }
        calc = new Calculator();
        initComponents();
    }
    
    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        calc.render(panelGraph.getGraphics(),panelGraph.getWidth(),panelGraph.getHeight());
        calc.update(tableValues);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGraph = new javax.swing.JPanel();
        buttonGraph = new javax.swing.JButton();
        sliderDegree = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableValues = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        boxAxis = new javax.swing.JCheckBox();
        boxGrid = new javax.swing.JCheckBox();
        boxCoords = new javax.swing.JCheckBox();
        fieldEquation = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelGraphLayout = new javax.swing.GroupLayout(panelGraph);
        panelGraph.setLayout(panelGraphLayout);
        panelGraphLayout.setHorizontalGroup(
            panelGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelGraphLayout.setVerticalGroup(
            panelGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );

        buttonGraph.setText("Graph");
        buttonGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGraphActionPerformed(evt);
            }
        });

        sliderDegree.setMajorTickSpacing(2);
        sliderDegree.setMaximum(10);
        sliderDegree.setMinorTickSpacing(1);
        sliderDegree.setPaintLabels(true);
        sliderDegree.setPaintTicks(true);
        sliderDegree.setSnapToTicks(true);
        sliderDegree.setValue(1);
        sliderDegree.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                sliderDegreePropertyChange(evt);
            }
        });

        tableValues.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "x", "f(x)", "Tn(x)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableValues);

        jLabel1.setText("Degree:");

        boxAxis.setSelected(true);
        boxAxis.setText("Axis");
        boxAxis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxAxisActionPerformed(evt);
            }
        });

        boxGrid.setText("Grid");
        boxGrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxGridActionPerformed(evt);
            }
        });

        boxCoords.setText("Coordinates");
        boxCoords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCoordsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addComponent(panelGraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonGraph)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sliderDegree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boxAxis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxGrid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxCoords))
                    .addComponent(fieldEquation, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fieldEquation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonGraph)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(sliderDegree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxAxis)
                            .addComponent(boxGrid)
                            .addComponent(boxCoords)))
                    .addComponent(panelGraph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGraphActionPerformed
        calc.setEquation(fieldEquation.getText());
        repaint();
    }//GEN-LAST:event_buttonGraphActionPerformed

    private void boxAxisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxAxisActionPerformed
        calc.axis = boxAxis.isSelected();
        repaint();
    }//GEN-LAST:event_boxAxisActionPerformed
    private void boxGridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxGridActionPerformed
        calc.grid = boxGrid.isSelected();
        repaint();
    }//GEN-LAST:event_boxGridActionPerformed
    private void boxCoordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCoordsActionPerformed
        calc.coords = boxCoords.isSelected();
        repaint();
    }//GEN-LAST:event_boxCoordsActionPerformed

    private void sliderDegreePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_sliderDegreePropertyChange
        calc.degree = sliderDegree.getValue();
        repaint();
    }//GEN-LAST:event_sliderDegreePropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox boxAxis;
    private javax.swing.JCheckBox boxCoords;
    private javax.swing.JCheckBox boxGrid;
    private javax.swing.JButton buttonGraph;
    private javax.swing.JFormattedTextField fieldEquation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelGraph;
    private javax.swing.JSlider sliderDegree;
    private javax.swing.JTable tableValues;
    // End of variables declaration//GEN-END:variables
}
