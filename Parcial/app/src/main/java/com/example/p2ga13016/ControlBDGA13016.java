package com.example.p2ga13016;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ControlBDGA13016 {

    private static final String[]camposDueño = new String []
            {"coddueño","nombre","apellido","patrimonio", "numequipos"};
    private static final String[]camposPais = new String []
            {"codpais","nompais","esEuropeo"};
    private static final String[] camposEquipo = new String []
            {"coddueño","codpais","correquipo","taquilla2019"};

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public ControlBDGA13016(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);

    }
    private static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String BASE_DATOS = "parcialGA13016.s3db";
        private static final int VERSION = 1;
        public DatabaseHelper(Context context) {
            super(context, BASE_DATOS, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                db.execSQL("CREATE TABLE dueño ( coddueño VARCHAR(6) NOT NULL PRIMARY KEY, nombre VARCHAR(30), apellido VARCHAR(30), patrimonio FLOAT, numequipos INTEGER);");

                //POSIBLE ERROR!
                db.execSQL("CREATE TABLE pais (\n" +
                        " codpais VARCHAR(3) NOT NULL PRIMARY KEY,\n" +
                        " nompais VARCHAR(30),\n" +
                        " esEuropeo VARCHAR(1));");


                db.execSQL("CREATE TABLE equipo ( coddueño VARCHAR(6) NOT NULL , codpais VARCHAR(3) NOT NULL , correquipo VARCHAR(2) ,taquilla2019 FLOAT , PRIMARY KEY(coddueño,codpais,correquipo), CONSTRAINT fk_equipo_pais FOREIGN KEY (codpais) REFERENCES pais(codpais) ON DELETE RESTRICT, CONSTRAINT fk_equipo_dueño FOREIGN KEY (coddueño) REFERENCES dueño(coddueño) ON DELETE RESTRICT);");


            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO Auto-generated method stub
        }
    }
    public void abrir() throws SQLException{
        db = DBHelper.getWritableDatabase();
        return;
    }
    public void cerrar(){
        DBHelper.close();
    }

    public String insertar(dueño dueño){

        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues due = new ContentValues();
        due.put("coddueño", dueño.getCoddueño());
        due.put("nombre", dueño.getNombre());
        due.put("apellido", dueño.getApellido());
        due.put("patrimonio", dueño.getPatrimonio());
        due.put("numequipos", dueño.getNumequipos());
        contador=db.insert("dueño", null, due);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;

        
    }

    public String insertar(pais pais){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues pai = new ContentValues();
        pai.put("codpais", pais.getCodpais());
        pai.put("nompais", pais.getNommapis());
        pai.put("esEuropeo", pais.getEsEuropeo());

        contador=db.insert("pais", null, pai);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

    public String insertar(equipo equipo){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues equi = new ContentValues();
        equi.put("coddueño", equipo.getCoddueño());
        equi.put("codpais", equipo.getCodpais());
        equi.put("correquipo", equipo.getCorreequipo());
        equi.put("taquilla2019", equipo.getTaquilla2019());

        contador=db.insert("equipo", null, equi);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
        
    }

    public int consultarEquipo(float taquilla){
        String[] id = {"Adolfo", "Salume"};
        dueño dueño = new dueño();

         Cursor c = db.query("dueño", camposDueño, "nombre=? AND apellido=?", id, null, null, null);

        if(c.moveToFirst()){

            //{"idMarca", "nombreMarca"}
            dueño.setCoddueño(c.getString(0));
        }

        else{
            dueño.setCoddueño("-1");
        }

        System.out.println("El dueno es:"+dueño.getCoddueño());

        String[] id2 ={dueño.getCoddueño(),String.valueOf(taquilla)};

        int contador;
        contador = db.query("equipo", camposEquipo, "coddueño=? AND taquilla2019<?",id2, null, null, null).getCount();

        return contador;
    }

    public String eliminar(pais pais){
        String regAfectados="filas afectadas= ";
        int contador=0;

        if (checarDependencia(pais.getCodpais()) > 0 || pais.getEsEuropeo()=="s") {

            regAfectados ="No se puede eliminar";
        }

        else {
            contador+=db.delete("pais", "codpais='"+pais.getCodpais()+"'", null);
            regAfectados+=contador;
        }


        return regAfectados;
    }

    public int checarDependencia(String id2) {
        String id[] = {String.valueOf(id2)};
        int contador;
        contador = db.query("equipo", camposEquipo, "codpais=?", id, null, null, null).getCount();

        return contador;
    }






    public String llenarBDCarnet(){
        final String[] VAcoddueño = {"OO12035","OF12044"};
        final String[] VAnombre = {"Carlos","Adolfo"};
        final String[] VAapellido = {"Orantes","Salume"};
        final Float[]  VApatrimonio = {Float.parseFloat("50"),Float.parseFloat("40")};
        final Integer[] VAnumequipo = {1,2};
        
        final String[] VNcodpais =
                {"123","134"};
        final String[] VNnompais =
                {"francia","mexico"};
        final String[] VNesEuropeo =
                {"s","n"};
        
        final String[] VLcoddueño = {"OF12044","OF12044"};
        final String[] Vlcodpais = {"123","1345"};
        final String[] Vlcorreequipo ={"ASUS1","MAC1"};
        final Float[] Vltaquilla2019 = {Float.parseFloat("100"),Float.parseFloat("200")};
    
   
        abrir();
        db.execSQL("DELETE FROM dueño");
        db.execSQL("DELETE FROM pais");
        db.execSQL("DELETE FROM equipo");
        
        dueño dueño = new dueño();
        for(int i=0;i<2;i++){
            dueño.setCoddueño(VAcoddueño[i]);
            dueño.setNombre(VAnombre[i]);
            dueño.setApellido(VAapellido[i]);
            dueño.setPatrimonio(VApatrimonio[i]);
            dueño.setNumequipos(VAnumequipo[i]);
            insertar(dueño);
        }
        pais pais = new pais();
        for(int i=0;i<2;i++){
            pais.setCodpais(VNcodpais[i]);
            pais.setNommapis(VNnompais[i]);
            pais.setEsEuropeo(VNesEuropeo[i]);
            insertar(pais);
        }
       equipo equipo = new equipo();
        for(int i=0;i<2;i++){
            equipo.setCoddueño(VLcoddueño[i]);
            equipo.setCodpais(Vlcodpais[i]);
            equipo.setCorreequipo(Vlcorreequipo[i]);
            equipo.setTaquilla2019(Vltaquilla2019[i]);
            insertar(equipo);
        }
        cerrar();
        return "Guardo Correctamente";
}
    }





