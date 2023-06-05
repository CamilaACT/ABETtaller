package Interfaces;

import javax.swing.*;

import Clases.*;
import Validacion.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Registro extends JFrame{
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTabbedPane txtRegRubCedula;
    private JTextField txtRegNom;
    private JTextField txtRegApellido;
    private JTextField txtRegCedula;
    private JTextField txtRegCorreo;
    private JTextField txtRegNumCuenta;
    private JComboBox comboRegDepart;
    private JTextField txtRegSueldo;
    private JTextArea txtRegEmplResultado;
    private JButton btnRegEmpleado;
    private JTabbedPane tabbedPane3;
    private JTextField txtModCed;
    private JButton btnModEmpleado;
    private JTextArea txtModResultado;
    private JPanel pnlModEmpleado;
    private JTextField txtModNombre;
    private JTextField txtModApellido;
    private JTextField txtModCorreo;
    private JTextField txtModNumCuenta;
    private JComboBox comboModDepartamento;
    private JTextField txtModSueldo;
    private JButton btnModRegistrar;
    private JTextField txtRegDepNom;
    private JTextField txtRegDepDescrip;
    private JButton registrarButton;
    private JTextArea txtRegDepResultado;
    private JPanel Departamento;
    private JTabbedPane tabbedPane4;
    private JButton btnVisNomina;
    private JTextArea txtVisNom;
    private JTextField txtvalidarrubro;
    private JButton btnRegRubBuscar;
    private JTextArea txtRegRubRsul;
    private JScrollPane txtRegRubResultado;
    private JPanel plnRegRubInfo;
    private JButton btnRegRubIngresar;
    private JComboBox combotipo;
    private JComboBox combomes;
    private JTextField txtmonto;
    private JTextField txtobservacion;
    private JTextField txtVisSuelCedula;
    private JButton btnVisSuelBuscar;
    private JTextArea textArea1;
    private JComboBox comboBuscarMes;
    private JButton buscarPorMes;
    private JTextArea txtSueldoubros;
    private JPanel plnbusqueda;
    private JTextField textField1;
    private JTextArea textArea2;
    private JButton imprimirButton;
    private JComboBox comboimpresion;
    private JButton btnQuemarDatos;
    private Validacion v1;
    private Modelo m1;
    private Empresa empresa;
    private Nomina nomina;
public Registro(String title) {
    super(title);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(panel1);
    this.pack();
    v1=new Validacion();
    m1=new Modelo();
    empresa=new Empresa("UDLA","AV.Nayón","1239087");
    nomina=new Nomina();
    cargarComboBox();
    cargarComboBox2();
    pnlModEmpleado.setVisible(false);
    plnRegRubInfo.setVisible(false);


    btnRegEmpleado.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //boolean validacion
            boolean [] validarTxt = new boolean[7];
            validarTxt[1]=txtRegNom.getText().isBlank();//retorna true si esta vacío el campo
            validarTxt[2]=txtRegApellido.getText().isBlank();
            validarTxt[3]=v1.validarCedula(txtRegCedula.getText());//retorna true si es cédula Ecuatoriana
            validarTxt[4]=txtRegCorreo.getText().isBlank();
            validarTxt[5]=txtRegNumCuenta.getText().isBlank();
            validarTxt[6]=v1.validacionStringInt(txtRegSueldo.getText());//retorna true si es valido

            if(validarTxt[3]){
                if(validarTxt[6]){
                    if(validarTxt[1]==false&&validarTxt[2]==false&&validarTxt[4]==false&&validarTxt[5]==false){
                        System.out.println("Cual es el indice que estoy seleccionando"+ comboRegDepart.getSelectedIndex());
                        if(nomina.addEmpleado(new Empleado(txtRegNom.getText(),txtRegApellido.getText(),txtRegCedula.getText(),txtRegCorreo.getText(),txtRegNumCuenta.getText(),Double.parseDouble(txtRegSueldo.getText()),comboRegDepart.getSelectedIndex()))){
                            txtRegEmplResultado.setText("Empleado Registrado con éxito");
                        }else{
                            txtRegEmplResultado.setText("Empleado ya existe en la nómina");
                        }



                    }else{
                        txtRegEmplResultado.setText("Verifique que todos los campos esten llenos");
                    }

                }else{
                    txtRegEmplResultado.setText("Verifique que el monto del sueldo sea válido");
                }
            }else{
                txtRegEmplResultado.setText("La cédula ingresada no es correcta");
            }
        }
    });
    registrarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            boolean [] validarTxt = new boolean[3];
            validarTxt[1]=txtRegDepNom.getText().isBlank();
            validarTxt[2]=txtRegDepDescrip.getText().isBlank();
            if(validarTxt[1]==false&&validarTxt[2]==false){
                if(empresa.addDepartamento(new Departamento(txtRegDepNom.getText(),txtRegDepDescrip.getText()))){
                    txtRegDepResultado.setText("Departamento ingresado correctamente");
                    cargarComboBox();
                    cargarComboBox2();
                }else{
                    txtRegDepResultado.setText("Departamento ya existente en la empresa");
                }
            }
        }
    });
    btnModEmpleado.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean validar;
            validar=v1.validarCedula(txtModCed.getText());//retorna true si es cédula Ecuatoriana

            if(validar){
                Empleado e1 =nomina.busquedaEmpleado(txtModCed.getText());
                if(e1!=null){
                    txtModResultado.setText(e1.toString());
                    pnlModEmpleado.setVisible(true);
                    btnModEmpleado.setEnabled(false);
                    txtModCed.setEnabled(false);
                }else{
                    txtModResultado.setText("No se econtraron resultados de busqueda");
                }
            }else{
                txtModResultado.setText("No se econtraron resultados de busqueda, verifique que sea una cédula válida");
            }
        }
    });
    btnModRegistrar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean [] validarTxt = new boolean[7];
            validarTxt[0]=txtModNombre.getText().isBlank();
            validarTxt[1]=txtModApellido.getText().isBlank();
            validarTxt[2]=txtModCorreo.getText().isBlank();
            validarTxt[3]=txtModNumCuenta.getText().isBlank();
            validarTxt[4]=v1.validacionStringInt(txtModSueldo.getText());

            if(validarTxt[4]&&validarTxt[0]==false&&validarTxt[1]==false&&validarTxt[2]==false&&validarTxt[3]==false){
                boolean verificacion = nomina.modificarDatos(txtModCed.getText(),txtModNombre.getText(),txtModApellido.getText(),txtModCorreo.getText(),txtModNumCuenta.getText(),Double.parseDouble(txtModSueldo.getText()),comboModDepartamento.getSelectedIndex());
                if(verificacion){
                    txtModResultado.setText("Cambios realizados con éxito");
                    pnlModEmpleado.setVisible(false);
                    btnModEmpleado.setEnabled(true);
                    txtModCed.setEnabled(true);
                    txtModCed.setText("");
                }else{
                    txtModResultado.setText("No se pudieron modificar los datos reintente nuevamente");
                    pnlModEmpleado.setVisible(false);
                }
            }else{
                txtModResultado.setText("Asegurese de llenar todos los campos");
                //pnlModEmpleado.setVisible(false);
            }

        }
    });
    btnVisNomina.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            txtVisNom.setText(nomina.getEmpleados().toString());
        }
    });
    btnRegRubBuscar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean validar;
            validar=v1.validarCedula(txtvalidarrubro.getText());//retorna true si es cédula Ecuatoriana

            if(validar){
                Empleado e1 =nomina.busquedaEmpleado(txtvalidarrubro.getText());
                if(e1!=null){
                    txtRegRubRsul.setText(e1.toString());
                    plnRegRubInfo.setVisible(true);
                    btnRegRubBuscar.setEnabled(false);
                    txtvalidarrubro.setEnabled(false);
                }else{
                    txtModResultado.setText("No se econtraron resultados de busqueda");
                }
            }else{
                txtModResultado.setText("No se econtraron resultados de busqueda, verifique que sea una cédula válida");
            }

        }
    });
    btnRegRubIngresar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Empleado e1 =nomina.busquedaEmpleado(txtvalidarrubro.getText());
            int tipo=combotipo.getSelectedIndex()+1;
            int mes=combomes.getSelectedIndex()+1;
            if(v1.validacionStringInt(txtmonto.getText())){
                e1.getSueldosEmpleado().addRubro((new Rubro(tipo,mes,Double.parseDouble(txtmonto.getText()),txtobservacion.getText())));
                txtRegRubRsul.setText("Rubro agregado Correctamente");
                plnRegRubInfo.setVisible(false);
                btnRegRubBuscar.setEnabled(true);
                txtvalidarrubro.setEnabled(true);
                txtvalidarrubro.setText("");
            }else{
                txtRegRubRsul.setText("LLene correctamente el monto");
            }
        }
    });
    btnVisSuelBuscar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean validar;
            validar=v1.validarCedula(txtVisSuelCedula.getText());//retorna true si es cédula Ecuatoriana

            if(validar){
                Empleado e1 =nomina.busquedaEmpleado(txtVisSuelCedula.getText());
                if(e1!=null){
                    textArea1.setText(e1.toString());
                    plnbusqueda.setVisible(true);
                    btnVisSuelBuscar.setEnabled(false);
                    txtVisSuelCedula.setEnabled(false);
                }else{
                    textArea1.setText("No se econtraron resultados de busqueda");
                }
            }else{
                textArea1.setText("No se econtraron resultados de busqueda, verifique que sea una cédula válida");
            }
        }
    });
    buscarPorMes.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Empleado e1 =nomina.busquedaEmpleado(txtVisSuelCedula.getText());
            textField1.setText("Sueldo: "+ e1.sueldoPorMes(comboBuscarMes.getSelectedIndex()+1));
            plnbusqueda.setVisible(false);
            btnVisSuelBuscar.setEnabled(true);
            txtVisSuelCedula.setEnabled(true);
            txtVisSuelCedula.setText("");
        }
    });
    imprimirButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea2.setText(nomina.imprimirNominaporMes(comboimpresion.getSelectedIndex()+1));
        }
    });
    btnQuemarDatos.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            nomina.addEmpleado(new Empleado("Camila","Cabrera","1711512663","camilcacabrera@gmail.com","A001234",500,1));
            nomina.addEmpleado(new Empleado("Rodrigo","Cabrera","1750473942","rodrigocabrera@gmail.com","A002525",800,2));
        }
    });
}

    private void cargarComboBox(){
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        comboRegDepart.setModel(comboBoxModel);
        List<String> nombres= empresa.nombresDepartamentos();
        String nombre="";
        for (int i=0;i<nombres.size();i++) {
                nombre=nombres.get(i);
                comboBoxModel.addElement(nombre);
            }

    }

    private void cargarComboBox2(){
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        comboModDepartamento.setModel(comboBoxModel);
        List<String> nombres= empresa.nombresDepartamentos();
        String nombre="";
        for (int i=0;i<nombres.size();i++) {
            nombre=nombres.get(i);
            comboBoxModel.addElement(nombre);
        }

    }

}
