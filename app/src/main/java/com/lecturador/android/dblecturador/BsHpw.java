package com.lecturador.android.dblecturador;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.lecturador.android.applecturador.ListaMedidores;
import com.lecturador.android.applecturador.RealizarLecturacion;
import com.lecturador.android.zebra.MyZebra;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dario Pardo on 4/19/2017.
 */
public class BsHpw implements Serializable {
    private int Nhpf;
    private int Anio;
    private int Mesf;
    private String Fgen;
    private String Fent;
    private String Fvto;
    private String Fcor;
    private int Nhpc;
    private int Ncat;
    private String Dcat;
    private int Lant;
    private int Lact;
    private int Cons;
    private int Conf;
    private double Imco;
    private String Fini;
    private String Ffin;
    private double Impt;
    private double Icfi;
    private double Imor;
    private int Nmor;
    private int Cmor;
    private String Cort;
    private String Desc;
    private int Cper;
    private String Nomb;
    private int Nmed;
    private String Nume;
    private int Ncnt;
    private int Nser;
    private int Dpto;
    private int Npro;
    private int Nciu;
    private String Dciu;
    private int Nuve;
    private String Duve;
    private int Nmza;
    private String Dmza;
    private int Nlot;
    private String Dlot;
    private int Nbar;
    private String Dbar;
    private int Nimb;
    private String Dimb;
    private int Nzon;
    private String Dzon;
    private int Nrut;
    private String Drut;
    private int Codf;
    private int Nred;
    private int Nvia;
    private int Nroi;
    private String Dire;
    private int Clas;
    private int Iplv;
    private int Nfac;
    private int Ntpc;
    private int Ntcn;
    private int Ndtb;
    private int Onof;
    private int Lmax;
    private int Conp;
    private int Kvat;
    private int Cobs;
    private int Nlec;
    private int Ptjc;
    private int Stad;
    private String Lati;
    private String Long;
    private int Stat;
    private int Ride;


    public BsHpw() {
        Nhpf = 0;
        Anio = 0;
        Mesf = 0;
        Fgen = "";
        Fent = "";
        Fvto = "";
        Fcor = "";
        Nhpc = 0;
        Ncat = 0;
        Dcat = "";
        Lant = 0;
        Lact = 0;
        Cons = 0;
        Conf = 0;
        Imco = 0;
        Fini = "";
        Ffin = "";
        Impt = 0;
        Icfi = 0;
        Imor = 0;
        Nmor = 0;
        Cmor = 0;
        Cort = "";
        Desc = "";
        Cper = 0;
        Nomb = "";
        Nmed = 0;
        Nume = "";
        Ncnt = 0;
        Nser = 0;
        Dpto = 0;
        Npro = 0;
        Nciu = 0;
        Dciu = "";
        Nuve = 0;
        Duve = "";
        Nmza = 0;
        Dmza = "";
        Nlot = 0;
        Dlot = "";
        Nbar = 0;
        Dbar = "";
        Nimb = 0;
        Dimb = "";
        Nzon = 0;
        Dzon = "";
        Nrut = 0;
        Drut = "";
        Codf = 0;
        Nred = 0;
        Nvia = 0;
        Nroi = 0;
        Dire = "";
        Clas = 0;
        Iplv = 0;
        Nfac = 0;
        Ntpc = 0;
        Ntcn = 0;
        Ndtb = 0;
        Onof = 0;
        Lmax = 0;
        Conp = 0;
        Kvat = 0;
        Cobs = 0;
        Nlec = 0;
        Ptjc = 0;
        Stad = 0;
        Lati = "";
        Long = "";
        Stat = 0;
        Ride = 0;
    }

    public int getNhpf() {
        return Nhpf;
    }

    public void setNhpf(int nhpf) {
        Nhpf = nhpf;
    }

    public int getAnio() {
        return Anio;
    }

    public void setAnio(int anio) {
        Anio = anio;
    }

    public int getMesf() {
        return Mesf;
    }

    public void setMesf(int mesf) {
        Mesf = mesf;
    }

    public String getFgen() {
        return Fgen;
    }

    public void setFgen(String fgen) {
        Fgen = fgen;
    }

    public String getFent() {
        return Fent;
    }

    public void setFent(String fent) {
        Fent = fent;
    }

    public String getFvto() {
        return Fvto;
    }

    public void setFvto(String fvto) {
        Fvto = fvto;
    }

    public String getFcor() {
        return Fcor;
    }

    public void setFcor(String fcor) {
        Fcor = fcor;
    }

    public int getNhpc() {
        return Nhpc;
    }

    public void setNhpc(int nhpc) {
        Nhpc = nhpc;
    }

    public int getNcat() {
        return Ncat;
    }

    public void setNcat(int ncat) {
        Ncat = ncat;
    }

    public String getDcat() {
        return Dcat;
    }

    public void setDcat(String dcat) {
        Dcat = dcat;
    }

    public int getLant() {
        return Lant;
    }

    public void setLant(int lant) {
        Lant = lant;
    }

    public int getLact() {
        return Lact;
    }

    public void setLact(int lact) {
        Lact = lact;
    }

    public int getCons() {
        return Cons;
    }

    public void setCons(int cons) {
        Cons = cons;
    }

    public int getConf() {
        return Conf;
    }

    public void setConf(int conf) {
        Conf = conf;
    }

    public double getImco() {
        return Imco;
    }

    public void setImco(double imco) {
        Imco = imco;
    }

    public String getFini() {
        return Fini;
    }

    public void setFini(String fini) {
        Fini = fini;
    }

    public String getFfin() {
        return Ffin;
    }

    public void setFfin(String ffin) {
        Ffin = ffin;
    }

    public double getImpt() {
        return Impt;
    }

    public void setImpt(double impt) {
        Impt = impt;
    }

    public double getIcfi() {
        return Icfi;
    }

    public void setIcfi(double icfi) {
        Icfi = icfi;
    }

    public double getImor() {
        return Imor;
    }

    public void setImor(double imor) {
        Imor = imor;
    }

    public int getNmor() {
        return Nmor;
    }

    public void setNmor(int nmor) {
        Nmor = nmor;
    }

    public int getCmor() {
        return Cmor;
    }

    public void setCmor(int cmor) {
        Cmor = cmor;
    }

    public String getCort() {
        return Cort;
    }

    public void setCort(String cort) {
        Cort = cort;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public int getCper() {
        return Cper;
    }

    public void setCper(int cper) {
        Cper = cper;
    }

    public String getNomb() {
        return Nomb;
    }

    public void setNomb(String nomb) {
        Nomb = nomb;
    }

    public int getNmed() {
        return Nmed;
    }

    public void setNmed(int nmed) {
        Nmed = nmed;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public int getNcnt() {
        return Ncnt;
    }

    public void setNcnt(int ncnt) {
        Ncnt = ncnt;
    }

    public int getNser() {
        return Nser;
    }

    public void setNser(int nser) {
        Nser = nser;
    }

    public int getDpto() {
        return Dpto;
    }

    public void setDpto(int dpto) {
        Dpto = dpto;
    }

    public int getNpro() {
        return Npro;
    }

    public void setNpro(int npro) {
        Npro = npro;
    }

    public int getNciu() {
        return Nciu;
    }

    public void setNciu(int nciu) {
        Nciu = nciu;
    }

    public String getDciu() {
        return Dciu;
    }

    public void setDciu(String dciu) {
        Dciu = dciu;
    }

    public int getNuve() {
        return Nuve;
    }

    public void setNuve(int nuve) {
        Nuve = nuve;
    }

    public String getDuve() {
        return Duve;
    }

    public void setDuve(String duve) {
        Duve = duve;
    }

    public int getNmza() {
        return Nmza;
    }

    public void setNmza(int nmza) {
        Nmza = nmza;
    }

    public String getDmza() {
        return Dmza;
    }

    public void setDmza(String dmza) {
        Dmza = dmza;
    }

    public int getNlot() {
        return Nlot;
    }

    public void setNlot(int nlot) {
        Nlot = nlot;
    }

    public String getDlot() {
        return Dlot;
    }

    public void setDlot(String dlot) {
        Dlot = dlot;
    }

    public int getNbar() {
        return Nbar;
    }

    public void setNbar(int nbar) {
        Nbar = nbar;
    }

    public String getDbar() {
        return Dbar;
    }

    public void setDbar(String dbar) {
        Dbar = dbar;
    }

    public int getNimb() {
        return Nimb;
    }

    public void setNimb(int nimb) {
        Nimb = nimb;
    }

    public String getDimb() {
        return Dimb;
    }

    public void setDimb(String dimb) {
        Dimb = dimb;
    }

    public int getNzon() {
        return Nzon;
    }

    public void setNzon(int nzon) {
        Nzon = nzon;
    }

    public String getDzon() {
        return Dzon;
    }

    public void setDzon(String dzon) {
        Dzon = dzon;
    }

    public int getNrut() {
        return Nrut;
    }

    public void setNrut(int nrut) {
        Nrut = nrut;
    }

    public String getDrut() {
        return Drut;
    }

    public void setDrut(String drut) {
        Drut = drut;
    }

    public int getCodf() {
        return Codf;
    }

    public void setCodf(int codf) {
        Codf = codf;
    }

    public int getNred() {
        return Nred;
    }

    public void setNred(int nred) {
        Nred = nred;
    }

    public int getNvia() {
        return Nvia;
    }

    public void setNvia(int nvia) {
        Nvia = nvia;
    }

    public int getNroi() {
        return Nroi;
    }

    public void setNroi(int nroi) {
        Nroi = nroi;
    }

    public String getDire() {
        return Dire;
    }

    public void setDire(String dire) {
        Dire = dire;
    }

    public int getClas() {
        return Clas;
    }

    public void setClas(int clas) {
        Clas = clas;
    }

    public int getIplv() {
        return Iplv;
    }

    public void setIplv(int iplv) {
        Iplv = iplv;
    }

    public int getNfac() {
        return Nfac;
    }

    public void setNfac(int nfac) {
        Nfac = nfac;
    }

    public int getNtpc() {
        return Ntpc;
    }

    public void setNtpc(int ntpc) {
        Ntpc = ntpc;
    }

    public int getNtcn() {
        return Ntcn;
    }

    public void setNtcn(int ntcn) {
        Ntcn = ntcn;
    }

    public int getNdtb() {
        return Ndtb;
    }

    public void setNdtb(int ndtb) {
        Ndtb = ndtb;
    }

    public int getOnof() {
        return Onof;
    }

    public void setOnof(int onof) {
        Onof = onof;
    }

    public int getLmax() {
        return Lmax;
    }

    public void setLmax(int lmax) {
        Lmax = lmax;
    }

    public int getConp() {
        return Conp;
    }

    public void setConp(int conp) {
        Conp = conp;
    }

    public int getKvat() {
        return Kvat;
    }

    public void setKvat(int kvat) {
        Kvat = kvat;
    }

    public int getCobs() {
        return Cobs;
    }

    public void setCobs(int cobs) {
        Cobs = cobs;
    }

    public int getNlec() {
        return Nlec;
    }

    public void setNlec(int nlec) {
        Nlec = nlec;
    }

    public int getPtjc() {
        return Ptjc;
    }

    public void setPtjc(int ptjc) {
        Ptjc = ptjc;
    }

    public int getStad() {
        return Stad;
    }

    public void setStad(int stad) {
        Stad = stad;
    }

    public String getLati() {
        return Lati;
    }

    public void setLati(String lati) {
        Lati = lati;
    }

    public String getLong() {
        return Long;
    }

    public void setLong(String aLong) {
        Long = aLong;
    }

    public int getStat() {
        return Stat;
    }

    public void setStat(int stat) {
        Stat = stat;
    }

    public int getRide() {
        return Ride;
    }

    public void setRide(int ride) {
        Ride = ride;
    }

    @Override
    public String toString() {
        return "BsHpw{" +
                "Nhpf=" + Nhpf +
                ", Anio=" + Anio +
                ", Mesf=" + Mesf +
                ", Fgen='" + Fgen + '\'' +
                ", Fent='" + Fent + '\'' +
                ", Fvto='" + Fvto + '\'' +
                ", Fcor='" + Fcor + '\'' +
                ", Nhpc=" + Nhpc +
                ", Ncat=" + Ncat +
                ", Dcat='" + Dcat + '\'' +
                ", Lant=" + Lant +
                ", Lact=" + Lact +
                ", Cons=" + Cons +
                ", Conf=" + Conf +
                ", Imco=" + Imco +
                ", Fini='" + Fini + '\'' +
                ", Ffin='" + Ffin + '\'' +
                ", Impt=" + Impt +
                ", Icfi=" + Icfi +
                ", Imor=" + Imor +
                ", Nmor=" + Nmor +
                ", Cmor=" + Cmor +
                ", Cort='" + Cort + '\'' +
                ", Desc='" + Desc + '\'' +
                ", Cper=" + Cper +
                ", Nomb='" + Nomb + '\'' +
                ", Nmed=" + Nmed +
                ", Nume='" + Nume + '\'' +
                ", Ncnt=" + Ncnt +
                ", Nser=" + Nser +
                ", Dpto=" + Dpto +
                ", Npro=" + Npro +
                ", Nciu=" + Nciu +
                ", Dciu='" + Dciu + '\'' +
                ", Nuve=" + Nuve +
                ", Duve='" + Duve + '\'' +
                ", Nmza=" + Nmza +
                ", Dmza='" + Dmza + '\'' +
                ", Nlot=" + Nlot +
                ", Dlot='" + Dlot + '\'' +
                ", Nbar=" + Nbar +
                ", Dbar='" + Dbar + '\'' +
                ", Nimb=" + Nimb +
                ", Dimb='" + Dimb + '\'' +
                ", Nzon=" + Nzon +
                ", Dzon='" + Dzon + '\'' +
                ", Nrut=" + Nrut +
                ", Drut='" + Drut + '\'' +
                ", Codf=" + Codf +
                ", Nred=" + Nred +
                ", Nvia=" + Nvia +
                ", Nroi=" + Nroi +
                ", Dire='" + Dire + '\'' +
                ", Clas=" + Clas +
                ", Iplv=" + Iplv +
                ", Nfac=" + Nfac +
                ", Ntpc=" + Ntpc +
                ", Ntcn=" + Ntcn +
                ", Ndtb=" + Ndtb +
                ", Onof=" + Onof +
                ", Lmax=" + Lmax +
                ", Conp=" + Conp +
                ", Kvat=" + Kvat +
                ", Cobs=" + Cobs +
                ", Nlec=" + Nlec +
                ", Ptjc=" + Ptjc +
                ", Stad=" + Stad +
                ", Lati=" + Lati +
                ", Long=" + Long +
                ", Stat=" + Stat +
                ", Ride=" + Ride +
                '}';
    }

    public void insertarBsHpw() {
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Nhpf);
        datos.add(this.Anio);
        datos.add(this.Mesf);
        datos.add(this.Fgen);
        datos.add(this.Fent);
        datos.add(this.Fvto);
        datos.add(this.Fcor);
        datos.add(this.Nhpc);
        datos.add(this.Ncat);
        datos.add(this.Dcat);
        datos.add(this.Lant);
        datos.add(this.Lact);
        datos.add(this.Cons);
        datos.add(this.Conf);
        datos.add(this.Imco);
        datos.add(this.Fini);
        datos.add(this.Ffin);
        datos.add(this.Impt);
        datos.add(this.Icfi);
        datos.add(this.Imor);
        datos.add(this.Nmor);
        datos.add(this.Cmor);
        datos.add(this.Cort);
        datos.add(this.Desc);
        datos.add(this.Cper);
        datos.add(this.Nomb);
        datos.add(this.Nmed);
        datos.add(this.Nume);
        datos.add(this.Ncnt);
        datos.add(this.Nser);
        datos.add(this.Dpto);
        datos.add(this.Npro);
        datos.add(this.Nciu);
        datos.add(this.Dciu);
        datos.add(this.Nuve);
        datos.add(this.Duve);
        datos.add(this.Nmza);
        datos.add(this.Dmza);
        datos.add(this.Nlot);
        datos.add(this.Dlot);
        datos.add(this.Nbar);
        datos.add(this.Dbar);
        datos.add(this.Nimb);
        datos.add(this.Dimb);
        datos.add(this.Nzon);
        datos.add(this.Dzon);
        datos.add(this.Nrut);
        datos.add(this.Drut);
        datos.add(this.Codf);
        datos.add(this.Nred);
        datos.add(this.Nvia);
        datos.add(this.Nroi);
        datos.add(this.Dire);
        datos.add(this.Clas);
        datos.add(this.Iplv);
        datos.add(this.Nfac);
        datos.add(this.Ntpc);
        datos.add(this.Ntcn);
        datos.add(this.Ndtb);
        datos.add(this.Onof);
        datos.add(this.Lmax);
        datos.add(this.Conp);
        datos.add(this.Kvat);
        datos.add(this.Cobs);
        datos.add(this.Nlec);
        datos.add(this.Ptjc);
        datos.add(this.Stad);
        datos.add(this.Lati);
        datos.add(this.Long);
        datos.add(this.Stat);
        datos.add(this.Ride);
        DBmanager.insertarTupla(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW, datos);
        DBmanager.CerrarBD();
    }

    public void guardarLecturaActual() {
        String lsConsulta = DBhelper.COLBSHPWNHPF + " = " + this.getNhpf() + " ";
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Lact);
        datos.add(this.Stat);
        String[] columna = new String[2];
        columna[0] = DBhelper.COLBSHPWLACT;
        columna[1] = DBhelper.COLBSHPWSTAT;
        DBmanager.modificarTupla(DBhelper.NOMTAHPW, columna, datos, lsConsulta);
        DBmanager.CerrarBD();
    }

    public void guardarImporteConsumo() {
        String lsConsulta = DBhelper.COLBSHPWNHPF + " = " + this.getNhpf() + " ";
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Imco);
        String[] columna = new String[1];
        columna[0] = DBhelper.COLBSHPWIMCO;
        DBmanager.modificarTupla(DBhelper.NOMTAHPW, columna, datos, lsConsulta);
        DBmanager.CerrarBD();
    }

    public void guardarConsumo() {
        String lsConsulta = DBhelper.COLBSHPWNHPF + " = " + this.getNhpf() + " ";
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Cons);
        String[] columna = new String[1];
        columna[0] = DBhelper.COLBSHPWCONS;
        DBmanager.modificarTupla(DBhelper.NOMTAHPW, columna, datos, lsConsulta);
        DBmanager.CerrarBD();
    }

    public void guardarObservacion() {
        String lsConsulta = DBhelper.COLBSHPWNHPF + " = " + this.getNhpf() + " ";
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Cobs);
        String[] columna = new String[1];
        columna[0] = DBhelper.COLBSHPWCOBS;
        DBmanager.modificarTupla(DBhelper.NOMTAHPW, columna, datos, lsConsulta);
        DBmanager.CerrarBD();
    }

    public void registrarUbicacion() {
        String lsConsulta = DBhelper.COLBSHPWNHPF + " = " + this.Nhpf + " ";
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Lati);
        datos.add(this.Long);
        Log.e("BSHPW", "registrarUbicacion: Latitud=" + this.Lati + " | Longitud=" + this.Long);
        String[] columna = new String[2];
        columna[0] = DBhelper.COLBSHPWLATI;
        columna[1] = DBhelper.COLBSHPWLONG;
        DBmanager.modificarTupla(DBhelper.NOMTAHPW, columna, datos, lsConsulta);
        DBmanager.CerrarBD();
    }


    public void actualizarEstado(int estado) {
        String lsConsulta = DBhelper.COLBSHPWNHPF + " = " + this.getNhpf() + " ";
        DBmanager.AbrirBD();
        this.Stad = estado;
        List<Object> datos = new ArrayList<Object>();
        datos.add(estado);
        String[] columna = new String[1];
        columna[0] = DBhelper.COLBSHPWSTAD;
        DBmanager.modificarTupla(DBhelper.NOMTAHPW, columna, datos, lsConsulta);
        DBmanager.CerrarBD();
    }

    public void registrarTotal(int nhpf) {
        obtenerBsHpw(nhpf);
        BsDpw dpw = new BsDpw();
        LinkedList<BsDpw> listDtl = dpw.listarDetalles(this.Nhpf);
        double total = 0;
        for (BsDpw dtl : listDtl) {
            total = total + dtl.getImpt();
        }
        this.setImpt(total);
        Double imor = total + this.getImor();
        this.setImor(imor);
        //this.Nmor=this.Nmor+1;
        this.setNmor(this.Nmor + 1);

        String lsConsulta = DBhelper.COLBSHPWNHPF + " = " + this.Nhpf + " ";
        DBmanager.AbrirBD();
        List<Object> datos = new ArrayList<Object>();
        datos.add(this.Impt);
        datos.add(this.Imor);
        datos.add(this.Nmor);
        String[] columna = new String[3];
        columna[0] = DBhelper.COLBSHPWIMPT;
        columna[1] = DBhelper.COLBSHPWIMOR;
        columna[2] = DBhelper.COLBSHPWNMOR;
        DBmanager.modificarTupla(DBhelper.NOMTAHPW, columna, datos, lsConsulta);
        DBmanager.CerrarBD();


    }

    public LinkedList<BsHpw> listarBsHpw() {
        LinkedList<BsHpw> listHpw = new LinkedList<>();
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.listarTabla(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW);

        while (cursor.moveToNext()) {
            BsHpw hpw = new BsHpw();
            hpw.setNhpf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPF))));
            hpw.setAnio(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWANIO))));
            hpw.setMesf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWMESF))));
            hpw.setFgen(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFGEN)));
            hpw.setFent(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFENT)));
            hpw.setFvto(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFVTO)));
            hpw.setFcor(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFCOR)));
            hpw.setNhpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPC))));
            hpw.setNcat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCAT))));
            hpw.setDcat(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCAT)));
            hpw.setLant(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLANT))));
            hpw.setLact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLACT))));
            hpw.setCons(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONS))));
            hpw.setConf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONF))));
            hpw.setImco(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMCO))));
            hpw.setFini(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFINI)));
            hpw.setFfin(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFFIN)));
            hpw.setImpt(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMPT))));
            hpw.setIcfi(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWICFI))));
            hpw.setImor(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMOR))));
            hpw.setNmor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMOR))));
            hpw.setCmor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCMOR))));
            hpw.setCort(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCORT)));
            hpw.setDesc(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDESC)));
            hpw.setCper(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCPER))));
            hpw.setNomb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNOMB)));
            hpw.setNmed(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMED))));
            hpw.setNume(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNUME)));
            hpw.setNcnt(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCNT))));
            hpw.setNser(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNSER))));
            hpw.setDpto(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDPTO))));
            hpw.setNpro(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNPRO))));
            hpw.setNciu(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCIU))));
            hpw.setDciu(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCIU)));
            hpw.setNuve(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNUVE))));
            hpw.setDuve(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDUVE)));
            hpw.setNmza(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMZA))));
            hpw.setDmza(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDMZA)));
            hpw.setNlot(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNLOT))));
            hpw.setDlot(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDLOT)));
            hpw.setNbar(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNBAR))));
            hpw.setDbar(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDBAR)));
            hpw.setNimb(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNIMB))));
            hpw.setDimb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIMB)));
            hpw.setNzon(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNZON))));
            hpw.setDzon(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDZON)));
            hpw.setNrut(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNRUT))));
            hpw.setDrut(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDRUT)));
            hpw.setCodf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCODF))));
            hpw.setNred(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNRED))));
            hpw.setNvia(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNVIA))));
            hpw.setNroi(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNROI))));
            hpw.setDire(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIRE)));
            hpw.setClas(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCLAS))));
            hpw.setIplv(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIPLV))));
            hpw.setNfac(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNFAC))));
            hpw.setNtpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNTPC))));
            hpw.setNtcn(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNTCN))));
            hpw.setNdtb(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNDTB))));
            hpw.setOnof(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWONOF))));
            hpw.setLmax(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLMAX))));
            hpw.setConp(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONP))));
            hpw.setKvat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWKVAT))));
            hpw.setCobs(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCOBS))));
            hpw.setNlec(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNLEC))));
            hpw.setPtjc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWPTJC))));
            hpw.setStad(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWSTAD))));
            hpw.setLati(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLATI)));
            hpw.setLong(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLONG)));
            hpw.setStat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWSTAT))));
            hpw.setRide(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWRIDE))));

            Log.e("BSHPW", "listarHPW se anhadio un Header a la lista ");


            listHpw.add(hpw);


        }

        return listHpw;
    }

    public LinkedList<BsHpw> listarNoLecturadosBsHpw() {
        LinkedList<BsHpw> listHpw = new LinkedList<>();
        DBmanager.AbrirBD();
        // Cursor cursor = DBmanager.listarTabla(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW);
        String condicion = DBhelper.COLBSHPWSTAT + " = 0";
        String orderby = DBhelper.COLBSHPWCODF + " ASC";
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW, condicion, orderby);
        while (cursor.moveToNext()) {
            BsHpw hpw = new BsHpw();
            hpw.setNhpf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPF))));
            hpw.setAnio(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWANIO))));
            hpw.setMesf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWMESF))));
            hpw.setFgen(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFGEN)));
            hpw.setFent(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFENT)));
            hpw.setFvto(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFVTO)));
            hpw.setFcor(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFCOR)));
            hpw.setNhpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPC))));
            hpw.setNcat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCAT))));
            hpw.setDcat(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCAT)));
            hpw.setLant(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLANT))));
            hpw.setLact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLACT))));
            hpw.setCons(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONS))));
            hpw.setConf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONF))));
            hpw.setImco(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMCO))));
            hpw.setFini(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFINI)));
            hpw.setFfin(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFFIN)));
            hpw.setImpt(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMPT))));
            hpw.setIcfi(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWICFI))));
            hpw.setImor(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMOR))));
            hpw.setNmor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMOR))));
            hpw.setCmor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCMOR))));
            hpw.setCort(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCORT)));
            hpw.setDesc(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDESC)));
            hpw.setCper(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCPER))));
            hpw.setNomb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNOMB)));
            hpw.setNmed(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMED))));
            hpw.setNume(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNUME)));
            hpw.setNcnt(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCNT))));
            hpw.setNser(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNSER))));
            hpw.setDpto(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDPTO))));
            hpw.setNpro(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNPRO))));
            hpw.setNciu(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCIU))));
            hpw.setDciu(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCIU)));
            hpw.setNuve(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNUVE))));
            hpw.setDuve(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDUVE)));
            hpw.setNmza(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMZA))));
            hpw.setDmza(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDMZA)));
            hpw.setNlot(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNLOT))));
            hpw.setDlot(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDLOT)));
            hpw.setNbar(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNBAR))));
            hpw.setDbar(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDBAR)));
            hpw.setNimb(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNIMB))));
            hpw.setDimb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIMB)));
            hpw.setNzon(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNZON))));
            hpw.setDzon(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDZON)));
            hpw.setNrut(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNRUT))));
            hpw.setDrut(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDRUT)));
            hpw.setCodf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCODF))));
            hpw.setNred(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNRED))));
            hpw.setNvia(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNVIA))));
            hpw.setNroi(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNROI))));
            hpw.setDire(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIRE)));
            hpw.setClas(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCLAS))));
            hpw.setIplv(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIPLV))));
            hpw.setNfac(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNFAC))));
            hpw.setNtpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNTPC))));
            hpw.setNtcn(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNTCN))));
            hpw.setNdtb(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNDTB))));
            hpw.setOnof(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWONOF))));
            hpw.setLmax(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLMAX))));
            hpw.setConp(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONP))));
            hpw.setKvat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWKVAT))));
            hpw.setCobs(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCOBS))));
            hpw.setNlec(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNLEC))));
            hpw.setPtjc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWPTJC))));
            hpw.setStad(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWSTAD))));
            hpw.setLati(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLATI)));
            hpw.setLong(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLONG)));
            hpw.setStat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWSTAT))));
            hpw.setRide(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWRIDE))));

            Log.e("BSHPW", "listarNoLecturadosBsHpw se anhadio un Header a la lista ");


            listHpw.add(hpw);


        }
        DBmanager.CerrarBD();
        return listHpw;
    }

    public LinkedList<BsHpw> listarLecturadosBsHpw() {
        LinkedList<BsHpw> listHpw = new LinkedList<>();
        DBmanager.AbrirBD();
        // Cursor cursor = DBmanager.listarTabla(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW);
        String condicion = DBhelper.COLBSHPWSTAT + " = -100 and " + DBhelper.COLBSHPWSTAD + " = 1";
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW, condicion, null);
        while (cursor.moveToNext()) {
            BsHpw hpw = new BsHpw();
            hpw.setNhpf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPF))));
            hpw.setAnio(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWANIO))));
            hpw.setMesf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWMESF))));
            hpw.setFgen(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFGEN)));
            hpw.setFent(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFENT)));
            hpw.setFvto(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFVTO)));
            hpw.setFcor(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFCOR)));
            hpw.setNhpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPC))));
            hpw.setNcat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCAT))));
            hpw.setDcat(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCAT)));
            hpw.setLant(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLANT))));
            hpw.setLact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLACT))));
            hpw.setCons(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONS))));
            hpw.setConf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONF))));
            hpw.setImco(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMCO))));
            hpw.setFini(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFINI)));
            hpw.setFfin(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFFIN)));
            hpw.setImpt(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMPT))));
            hpw.setIcfi(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWICFI))));
            hpw.setImor(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMOR))));
            hpw.setNmor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMOR))));
            hpw.setCmor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCMOR))));
            hpw.setCort(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCORT)));
            hpw.setDesc(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDESC)));
            hpw.setCper(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCPER))));
            hpw.setNomb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNOMB)));
            hpw.setNmed(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMED))));
            hpw.setNume(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNUME)));
            hpw.setNcnt(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCNT))));
            hpw.setNser(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNSER))));
            hpw.setDpto(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDPTO))));
            hpw.setNpro(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNPRO))));
            hpw.setNciu(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCIU))));
            hpw.setDciu(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCIU)));
            hpw.setNuve(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNUVE))));
            hpw.setDuve(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDUVE)));
            hpw.setNmza(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMZA))));
            hpw.setDmza(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDMZA)));
            hpw.setNlot(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNLOT))));
            hpw.setDlot(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDLOT)));
            hpw.setNbar(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNBAR))));
            hpw.setDbar(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDBAR)));
            hpw.setNimb(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNIMB))));
            hpw.setDimb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIMB)));
            hpw.setNzon(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNZON))));
            hpw.setDzon(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDZON)));
            hpw.setNrut(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNRUT))));
            hpw.setDrut(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDRUT)));
            hpw.setCodf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCODF))));
            hpw.setNred(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNRED))));
            hpw.setNvia(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNVIA))));
            hpw.setNroi(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNROI))));
            hpw.setDire(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIRE)));
            hpw.setClas(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCLAS))));
            hpw.setIplv(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIPLV))));
            hpw.setNfac(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNFAC))));
            hpw.setNtpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNTPC))));
            hpw.setNtcn(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNTCN))));
            hpw.setNdtb(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNDTB))));
            hpw.setOnof(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWONOF))));
            hpw.setLmax(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLMAX))));
            hpw.setConp(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONP))));
            hpw.setKvat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWKVAT))));
            hpw.setCobs(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCOBS))));
            hpw.setNlec(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNLEC))));
            hpw.setPtjc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWPTJC))));
            hpw.setStad(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWSTAD))));
            hpw.setLati(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLATI)));
            hpw.setLong(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLONG)));
            hpw.setStat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWSTAT))));
            hpw.setRide(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWRIDE))));

            Log.e("BSHPW", "listarLecturadosBsHpw se anhadio un Header a la lista ");
            listHpw.add(hpw);
        }
        return listHpw;
    }

    public void obtenerBsHpw(int nhpf) {
        // LinkedList<BsHpw> listHpw = new LinkedList<>();
        DBmanager.AbrirBD();
        // Cursor cursor = DBmanager.listarTabla(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW);
        String condicion = DBhelper.COLBSHPWNHPF + " = " + nhpf;
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW, condicion, null);
        BsHpw hpw = new BsHpw();
        if (cursor.moveToNext()) {
            // BsHpw hpw = new BsHpw();
            this.setNhpf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPF))));
            this.setAnio(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWANIO))));
            this.setMesf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWMESF))));
            this.setFgen(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFGEN)));
            this.setFent(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFENT)));
            this.setFvto(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFVTO)));
            this.setFcor(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFCOR)));
            this.setNhpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPC))));
            this.setNcat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCAT))));
            this.setDcat(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCAT)));
            this.setLant(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLANT))));
            this.setLact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLACT))));
            this.setCons(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONS))));
            this.setConf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONF))));
            this.setImco(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMCO))));
            this.setFini(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFINI)));
            this.setFfin(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFFIN)));
            this.setImpt(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMPT))));
            this.setIcfi(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWICFI))));
            this.setImor(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMOR))));
            this.setNmor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMOR))));
            this.setCmor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCMOR))));
            this.setCort(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCORT)));
            this.setDesc(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDESC)));
            this.setCper(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCPER))));
            this.setNomb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNOMB)));
            this.setNmed(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMED))));
            this.setNume(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNUME)));
            this.setNcnt(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCNT))));
            this.setNser(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNSER))));
            this.setDpto(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDPTO))));
            this.setNpro(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNPRO))));
            this.setNciu(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCIU))));
            this.setDciu(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCIU)));
            this.setNuve(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNUVE))));
            this.setDuve(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDUVE)));
            this.setNmza(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMZA))));
            this.setDmza(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDMZA)));
            this.setNlot(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNLOT))));
            this.setDlot(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDLOT)));
            this.setNbar(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNBAR))));
            this.setDbar(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDBAR)));
            this.setNimb(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNIMB))));
            this.setDimb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIMB)));
            this.setNzon(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNZON))));
            this.setDzon(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDZON)));
            this.setNrut(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNRUT))));
            this.setDrut(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDRUT)));
            this.setCodf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCODF))));
            this.setNred(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNRED))));
            this.setNvia(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNVIA))));
            this.setNroi(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNROI))));
            this.setDire(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIRE)));
            this.setClas(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCLAS))));
            this.setIplv(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIPLV))));
            this.setNfac(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNFAC))));
            this.setNtpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNTPC))));
            this.setNtcn(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNTCN))));
            this.setNdtb(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNDTB))));
            this.setOnof(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWONOF))));
            this.setLmax(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLMAX))));
            this.setConp(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONP))));
            this.setKvat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWKVAT))));
            this.setCobs(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCOBS))));
            this.setNlec(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNLEC))));
            this.setPtjc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWPTJC))));
            this.setStad(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWSTAD))));
            this.setLati(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLATI)));
            this.setLong(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLONG)));
            this.setStat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWSTAT))));
            this.setRide(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWRIDE))));

            Log.e("BSHPW", "obtenerBsHpw se obtiene el Header con el nhpf= " + nhpf);
        }

    }


    public boolean obtenerBsHpwByNroContrato(int NroContrato) {

        boolean existe = false;
        DBmanager.AbrirBD();
        String condicion = DBhelper.COLBSHPWCODF + " = " + NroContrato;
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW, condicion, null);
        BsHpw hpw = new BsHpw();
        if (cursor.moveToNext()) {
            // BsHpw hpw = new BsHpw();
            this.setNhpf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPF))));
            this.setAnio(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWANIO))));
            this.setMesf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWMESF))));
            this.setFgen(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFGEN)));
            this.setFent(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFENT)));
            this.setFvto(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFVTO)));
            this.setFcor(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFCOR)));
            this.setNhpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPC))));
            this.setNcat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCAT))));
            this.setDcat(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCAT)));
            this.setLant(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLANT))));
            this.setLact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLACT))));
            this.setCons(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONS))));
            this.setConf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONF))));
            this.setImco(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMCO))));
            this.setFini(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFINI)));
            this.setFfin(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFFIN)));
            this.setImpt(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMPT))));
            this.setIcfi(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWICFI))));
            this.setImor(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMOR))));
            this.setNmor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMOR))));
            this.setCmor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCMOR))));
            this.setCort(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCORT)));
            this.setDesc(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDESC)));
            this.setCper(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCPER))));
            this.setNomb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNOMB)));
            this.setNmed(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMED))));
            this.setNume(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNUME)));
            this.setNcnt(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCNT))));
            this.setNser(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNSER))));
            this.setDpto(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDPTO))));
            this.setNpro(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNPRO))));
            this.setNciu(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCIU))));
            this.setDciu(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCIU)));
            this.setNuve(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNUVE))));
            this.setDuve(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDUVE)));
            this.setNmza(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMZA))));
            this.setDmza(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDMZA)));
            this.setNlot(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNLOT))));
            this.setDlot(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDLOT)));
            this.setNbar(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNBAR))));
            this.setDbar(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDBAR)));
            this.setNimb(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNIMB))));
            this.setDimb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIMB)));
            this.setNzon(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNZON))));
            this.setDzon(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDZON)));
            this.setNrut(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNRUT))));
            this.setDrut(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDRUT)));
            this.setCodf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCODF))));
            this.setNred(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNRED))));
            this.setNvia(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNVIA))));
            this.setNroi(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNROI))));
            this.setDire(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIRE)));
            this.setClas(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCLAS))));
            this.setIplv(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIPLV))));
            this.setNfac(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNFAC))));
            this.setNtpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNTPC))));
            this.setNtcn(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNTCN))));
            this.setNdtb(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNDTB))));
            this.setOnof(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWONOF))));
            this.setLmax(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLMAX))));
            this.setConp(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONP))));
            this.setKvat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWKVAT))));
            this.setCobs(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCOBS))));
            this.setNlec(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNLEC))));
            this.setPtjc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWPTJC))));
            this.setStad(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWSTAD))));
            this.setLati(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLATI)));
            this.setLong(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLONG)));
            this.setStat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWSTAT))));
            this.setRide(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWRIDE))));

            existe = true;
            Log.e("BSHPW", "obtenerBsHpwByCodigoFijo se obtiene el Header con el NroContrato= " + NroContrato);
        }
        return existe;
    }

    public int countRegister() {
        int cant = DBmanager.Cantidad_de_Registros(DBhelper.NOMTAHPW);
        return cant;
    }

    public boolean obtenerBsHpwByCodFijo(int liNcnt) {
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW, DBhelper.COLBSHPWNCNT + " = " + liNcnt, (String) null);
        new BsHpw();
        if (!cursor.moveToNext()) {
            return false;
        }
        setNhpf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPF))).intValue());
        setAnio(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWANIO))).intValue());
        setMesf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWMESF))).intValue());
        setFgen(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFGEN)));
        setFent(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFENT)));
        setFvto(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFVTO)));
        setFcor(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFCOR)));
        setNhpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPC))).intValue());
        setNcat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCAT))).intValue());
        setDcat(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCAT)));
        setLant(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLANT))).intValue());
        setLact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLACT))).intValue());
        setCons(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONS))).intValue());
        setConf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONF))).intValue());
        setImco(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMCO))).doubleValue());
        setFini(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFINI)));
        setFfin(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFFIN)));
        setImpt(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMPT))).doubleValue());
        setIcfi(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWICFI))).doubleValue());
        setImor(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMOR))).doubleValue());
        setNmor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMOR))).intValue());
        setCmor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCMOR))).intValue());
        setCort(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCORT)));
        setDesc(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDESC)));
        setCper(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCPER))).intValue());
        setNomb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNOMB)));
        setNmed(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMED))).intValue());
        setNume(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNUME)));
        setNcnt(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCNT))).intValue());
        setNser(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNSER))).intValue());
        setDpto(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDPTO))).intValue());
        setNpro(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNPRO))).intValue());
        setNciu(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCIU))).intValue());
        setDciu(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCIU)));
        setNuve(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNUVE))).intValue());
        setDuve(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDUVE)));
        setNmza(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMZA))).intValue());
        setDmza(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDMZA)));
        setNlot(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNLOT))).intValue());
        setDlot(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDLOT)));
        setNbar(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNBAR))).intValue());
        setDbar(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDBAR)));
        setNimb(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNIMB))).intValue());
        setDimb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIMB)));
        setNzon(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNZON))).intValue());
        setDzon(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDZON)));
        setNrut(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNRUT))).intValue());
        setDrut(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDRUT)));
        setCodf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCODF))).intValue());
        setNred(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNRED))).intValue());
        setNvia(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNVIA))).intValue());
        setNroi(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNROI))).intValue());
        setDire(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIRE)));
        setClas(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCLAS))).intValue());
        setIplv(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIPLV))).intValue());
        setNfac(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNFAC))).intValue());
        setNtpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNTPC))).intValue());
        setNtcn(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNTCN))).intValue());
        setNdtb(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNDTB))).intValue());
        setOnof(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWONOF))).intValue());
        setLmax(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLMAX))).intValue());
        setConp(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONP))).intValue());
        setKvat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWKVAT))).intValue());
        setCobs(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCOBS))).intValue());
        setNlec(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNLEC))).intValue());
        setPtjc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWPTJC))).intValue());
        setStad(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWSTAD))).intValue());
        setLati(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLATI)));
        setLong(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLONG)));
        setStat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWSTAT))).intValue());
        setRide(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWRIDE))).intValue());
        Log.e("BSHPW", "obtenerBsHpwByCodigoFijo se obtiene el Header con el NroContrato= " + liNcnt);
        return true;
    }

    public boolean obtenerBsHpwByCodUbicacion(int liCodf) {
        DBmanager.AbrirBD();
        Cursor cursor = DBmanager.buscarTuplas(DBhelper.NOMTAHPW, DBhelper.COLSBSHPW, DBhelper.COLBSHPWCODF + " = " + liCodf, (String) null);
        new BsHpw();
        if (!cursor.moveToNext()) {
            return false;
        }
        setNhpf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPF))).intValue());
        setAnio(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWANIO))).intValue());
        setMesf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWMESF))).intValue());
        setFgen(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFGEN)));
        setFent(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFENT)));
        setFvto(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFVTO)));
        setFcor(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFCOR)));
        setNhpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNHPC))).intValue());
        setNcat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCAT))).intValue());
        setDcat(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCAT)));
        setLant(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLANT))).intValue());
        setLact(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLACT))).intValue());
        setCons(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONS))).intValue());
        setConf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONF))).intValue());
        setImco(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMCO))).doubleValue());
        setFini(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFINI)));
        setFfin(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWFFIN)));
        setImpt(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMPT))).doubleValue());
        setIcfi(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWICFI))).doubleValue());
        setImor(Double.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIMOR))).doubleValue());
        setNmor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMOR))).intValue());
        setCmor(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCMOR))).intValue());
        setCort(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCORT)));
        setDesc(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDESC)));
        setCper(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCPER))).intValue());
        setNomb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNOMB)));
        setNmed(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMED))).intValue());
        setNume(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNUME)));
        setNcnt(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCNT))).intValue());
        setNser(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNSER))).intValue());
        setDpto(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDPTO))).intValue());
        setNpro(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNPRO))).intValue());
        setNciu(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNCIU))).intValue());
        setDciu(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDCIU)));
        setNuve(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNUVE))).intValue());
        setDuve(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDUVE)));
        setNmza(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNMZA))).intValue());
        setDmza(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDMZA)));
        setNlot(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNLOT))).intValue());
        setDlot(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDLOT)));
        setNbar(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNBAR))).intValue());
        setDbar(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDBAR)));
        setNimb(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNIMB))).intValue());
        setDimb(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIMB)));
        setNzon(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNZON))).intValue());
        setDzon(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDZON)));
        setNrut(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNRUT))).intValue());
        setDrut(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDRUT)));
        setCodf(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCODF))).intValue());
        setNred(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNRED))).intValue());
        setNvia(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNVIA))).intValue());
        setNroi(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNROI))).intValue());
        setDire(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWDIRE)));
        setClas(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCLAS))).intValue());
        setIplv(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWIPLV))).intValue());
        setNfac(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNFAC))).intValue());
        setNtpc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNTPC))).intValue());
        setNtcn(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNTCN))).intValue());
        setNdtb(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNDTB))).intValue());
        setOnof(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWONOF))).intValue());
        setLmax(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLMAX))).intValue());
        setConp(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCONP))).intValue());
        setKvat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWKVAT))).intValue());
        setCobs(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWCOBS))).intValue());
        setNlec(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWNLEC))).intValue());
        setPtjc(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWPTJC))).intValue());
        setStad(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWSTAD))).intValue());
        setLati(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLATI)));
        setLong(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWLONG)));
        setStat(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWSTAT))).intValue());
        setRide(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBhelper.COLBSHPWRIDE))).intValue());
        Log.e("BSHPW", "obtenerBsHpwByCodigoFijo se obtiene el Header con el NroContrato= " + liCodf);
        return true;
    }


    public double calcularCovid(int nhpf, double imptConsumoyAlcantarilla, BsHpw loitemLecturacion) {
        BsHpw hpw = new BsHpw();
        BsTaw taw = new BsTaw();
        hpw.obtenerBsHpw(nhpf);
        BsDpw dpw = new BsDpw();
        dpw.obtenerDpw(hpw.getNhpf(), 7101);
        double lfImporte = 0.0d;
        if (dpw.getNhpc() != 0) {
            List<BsTaw> listTaw = taw.obtenerTarifa(loitemLecturacion.getAnio(), loitemLecturacion.getMesf(), 7101, loitemLecturacion.getNcat());
            for (BsTaw tar:listTaw) {
                double val1 = tar.getVal1();
                int cmon = tar.getCmon();
                String fiva = tar.getFiva().trim();
                String vafa = tar.getVafa().trim();
                if (cmon == 2) {
                    val1 *= dpw.getTcam();
                }
                char lfiva = fiva.charAt(0);
                char lvafa = vafa.charAt(0);
                BsHpw hpw2 = hpw;
                if ('F' == lfiva && 'F' == lvafa) {
                    lfImporte = imptConsumoyAlcantarilla * (val1 / 100.0d);
                } else if ('F' == lfiva && 'V' == lvafa) {
                    lfImporte = val1;
                }
                hpw = hpw2;
            }
            dpw.setPuni(lfImporte);
            dpw.registrarPrecioUnitario();
            dpw.setImpt(lfImporte);
            dpw.registrarImporte();
        }
        return lfImporte;
    }



    public Double calcularConsumo(int nhpf, BsHpw loitemLecturacion, Context context) {
        BsHpw hpw = new BsHpw();
        hpw.obtenerBsHpw(nhpf);
        BsDpw dpw = new BsDpw();
        dpw.obtenerDpw(loitemLecturacion.getNhpf(), loitemLecturacion.getNhpc());

        double consumo = 0;
        if (loitemLecturacion.getNmed() == 0) {
            BsTaw taw = new BsTaw();
            taw = taw.obtenerTarifaDesde(loitemLecturacion.getAnio(), loitemLecturacion.getMesf(), loitemLecturacion.getNhpc(), loitemLecturacion.getNcat(), 0);
            consumo = taw.getHast();
        } else {
            consumo = loitemLecturacion.getLact() - loitemLecturacion.getLant();
        }

        if (consumo < 0) {
            Toast.makeText(context, "Consumo Negativo, Digite Nuevamente la lectura", Toast.LENGTH_LONG).show();
        }
        loitemLecturacion.setCons((int) consumo);
        loitemLecturacion.guardarConsumo();
        double importe = 0;
        //calcConsumo(consumo);

        if (consumo == 0) {
            //consumo = 1;
            dpw.setCant(1);
        } else {
            dpw.setCant(consumo);
        }
        dpw.registrarCantidad();

        // si no tiene medidor tomar el consumo= taw.hasta
        // si no tiene medidor lectura=0


        Double rango = 0.0;
        Double aux = 0.0;

        BsTaw taw = new BsTaw();
        aux = consumo;

        LinkedList<BsTaw> tarifas = taw.obtenerTarifa(loitemLecturacion.getAnio(), loitemLecturacion.getMesf(),
                loitemLecturacion.getNhpc(), loitemLecturacion.getNcat());
        for (BsTaw tar : tarifas) {
            int desde = tar.getDesd();
            int hasta = tar.getHast();

            //if (loitemLecturacion.getNmed() == 0) {
            //    consumo = hasta;
            //}

            double val1 = tar.getVal1();
            int cmon = tar.getCmon();
            double tcam = dpw.getTcam();
            String fiva = tar.getFiva().trim();
            String vafa = tar.getVafa().trim();

            //if (desde == 0) { // consumo minimo

            //    // aqui hay que meter

            //    if (consumo <= hasta) {
            //        rango = consumo;
            //        importe = importe + AnalisisImporte(rango, val1, cmon,
            //                tcam, fiva, vafa);

            //        double precioUnitario = importe / dpw.getCant();
            //        dpw.setPuni(precioUnitario);
            //        dpw.registrarPrecioUnitario();
            //        dpw.setImpt(importe);
            //        dpw.registrarImporte();

            //        return importe;
            //    } else {
            //        rango = hasta - desde + 0.0;
            //    }
            //} else {
            //    if (consumo >= hasta) {
            //        rango = hasta - desde + 1.0;
            //    } else {
            //        rango = aux;
            //    }
            //}

            if (desde != 0) {

                if (consumo >=  hasta) {
                    rango =  hasta - desde + 1.0;
                } else {
                    rango = aux;
                }
            } else if (consumo <=  hasta) {
                int i = hasta;

                importe = importe + AnalisisImporte(consumo, val1, cmon, tcam, fiva, vafa);
                dpw.setPuni(importe / dpw.getCant());
                dpw.registrarPrecioUnitario();
                dpw.setImpt(importe);
                dpw.registrarImporte();
                return importe;
            } else {
                rango = hasta - desde +0.0;
            }
            importe = importe  + AnalisisImporte(rango, val1, cmon, tcam, fiva, vafa);
            aux = aux - rango;
        }

        double precioUnitario = importe / dpw.getCant();
        dpw.setPuni(precioUnitario);
        dpw.registrarPrecioUnitario();
        dpw.setImpt(importe);
        dpw.registrarImporte();
        return importe;
    }

    public double calcConsumo(double consumo, BsHpw loitemLecturacion) {
        BsTaw taw = new BsTaw();
        LinkedList<BsTaw> tarifas = taw.obtenerTarifa(loitemLecturacion.getAnio(), loitemLecturacion.getMesf(),
                loitemLecturacion.getNhpc(), loitemLecturacion.getNcat());

        BsDpw dpw = new BsDpw();
        dpw.obtenerDpw(loitemLecturacion.getNhpf(), loitemLecturacion.getNhpc());

        Double rango = 0.0;
        Double liConAux = consumo;
        double importe = 0.0;
        for (BsTaw tar : tarifas) {
            int desde = tar.getDesd();
            int hasta = tar.getHast();
            double val1 = tar.getVal1();
            int cmon = tar.getCmon();
            double tcam = dpw.getTcam();
            String fiva = tar.getFiva().trim();
            String vafa = tar.getVafa().trim();
            if (desde == 0) { // consumo minimo
                if (consumo < hasta) {
                    rango = consumo;
                    importe = importe + AnalisisImporte(rango, val1, cmon,
                            tcam, fiva, vafa);
                    return importe;
                } else {
                    rango = hasta - desde + 0.0;
                }
            } else {
                if (consumo >= hasta) {
                    rango = hasta - desde + 1.0;
                } else {
                    rango = liConAux;
                }
            }
            double aimpt = AnalisisImporte(rango, val1, cmon, tcam, fiva, vafa);
            importe = importe + aimpt;
            liConAux = liConAux - rango;
        }
        return importe;
    }

    public void calcularDescuentoLey(int nhpf, BsHpw loitemLecturacion ) {
        BsHpw hpw = new BsHpw();
        hpw.obtenerBsHpw(nhpf);
        BsDpw dpw = new BsDpw();
        dpw.obtenerDpw(hpw.getNhpf(), 7050);
        int liMinLey =0;
        double dctoLey = 0;
        if (dpw.getNhpc() != 0) {
            BsTaw taw = new BsTaw();
            BsTaw tarifa = taw.obtenerTarifaDesde(hpw.getAnio(), hpw.getMesf(), 7050, hpw.getNcat(), 0);

            if (tarifa.getNhpc() == 7050) {

                 liMinLey = tarifa.getHast();

                BsTaw tarifaMin = taw.obtenerTarifaDesde(hpw.getAnio(), hpw.getMesf(),
                        hpw.getNhpc(), hpw.getNcat(), 0);
                int liMinConsumo = tarifaMin.getHast();

                //'1.2. si el consumo enviado es menor al minimo consumido -> queda con el valor minimo
                if (hpw.getCons() <= liMinConsumo) {
                    liMinLey = liMinConsumo;
                } else {
                    // ' si es mayor analizamos y es menor al minimo descto ley le ponemos el consumo enviado
                    if (hpw.getCons() < liMinLey) {
                        liMinLey = loitemLecturacion.getCons();
                    }
                }

                double lfImpConMin = calcConsumo(liMinLey,loitemLecturacion);
                double lfRecuInv = 0;//recuperacionInversionDeLey(nhpf, lfImpConMin); // para otras empresas
                double lfAlcan = calcularAlcantarillaDeLey(nhpf, lfImpConMin + lfRecuInv, loitemLecturacion);  // para otras empresas

                LinkedList<BsTaw> listTarifas = taw.obtenerTarifa(hpw.getAnio(), hpw.getMesf(), 7050, hpw.getNcat());

                for (BsTaw tar : listTarifas) {
                    int desde = tar.getDesd();
                    int hasta = tar.getHast();
                    double val1 = tar.getVal1();
                    int cmon = tar.getCmon();
                    double tcam = dpw.getTcam();
                    String fiva = tar.getFiva().trim();
                    String vafa = tar.getVafa().trim();

                    if (liMinLey >= desde && liMinLey <= hasta) {

                        char lfiva = fiva.charAt(0);
                        char lvafa = vafa.charAt(0);
                        if ('V' == lvafa) { // NO interesa el consumo
                            if (cmon == 1) { // si es bolivianos
                                dctoLey = dctoLey + val1;
                            } else {  // es Dolares
                                dctoLey = dctoLey + (val1 * tcam);
                            }
                        } else {
                            dctoLey = dctoLey + (lfImpConMin + lfRecuInv + lfAlcan) * (val1 / 100);
                        }
                    }
                }

                dpw.setCant(1);
                dpw.registrarCantidad();

                double precioUnitario = dctoLey;
                dpw.setPuni(precioUnitario);
                dpw.registrarPrecioUnitario();

                dpw.setImpt(dctoLey);
                dpw.registrarImporte();
            }

        }
    }

    public double calcularAlcantarilla(int nhpf, double importeConsumo, BsHpw loitemLecturacion) {
        BsHpw hpw = new BsHpw();
        hpw.obtenerBsHpw(nhpf);
        BsDpw dpw = new BsDpw();
        dpw.obtenerDpw(hpw.getNhpf(), 7004);
        double lfImporte = 0;
        if (dpw.getNhpc() != 0) {
            double ldAlcantarilla = 0;

            BsTaw taw = new BsTaw();
            LinkedList<BsTaw> listTarifas = taw.obtenerTarifa(loitemLecturacion.getAnio(), loitemLecturacion.getMesf(), 7004, loitemLecturacion.getNcat());

            for (BsTaw tar : listTarifas) {
                int desde = tar.getDesd();
                int hasta = tar.getHast();
                double val1 = tar.getVal1();
                int cmon = tar.getCmon();

                String fiva = tar.getFiva().trim();
                String vafa = tar.getVafa().trim();

                if (cmon == 2) {  // en dolares convertir a bolivianos
                    val1 = val1 * dpw.getTcam();
                }

                char lfiva = fiva.charAt(0);
                char lvafa = vafa.charAt(0);
                if ('F' == lfiva && 'F' == lvafa) { // NO interesa el consumo
                    lfImporte = importeConsumo * (val1 / 100);
                } else if ('F' == lfiva && 'V' == lvafa) { // SI interesa el consumo
                    lfImporte = val1;
                }
            }
            dpw.setPuni(lfImporte);
            dpw.registrarPrecioUnitario();

            dpw.setImpt(lfImporte);
            dpw.registrarImporte();

        }


        return lfImporte;
    }

    public double calcularAlcantarillaDeLey(int nhpf, double importeConsumo, BsHpw loitemLecturacion) {
        BsHpw hpw = new BsHpw();
        hpw.obtenerBsHpw(nhpf);
        BsDpw dpw = new BsDpw();
        dpw.obtenerDpw(hpw.getNhpf(), 7004);
        double lfImporte = 0;
        if (dpw.getNhpc() != 0) {
            double ldAlcantarilla = 0;

            BsTaw taw = new BsTaw();
            LinkedList<BsTaw> listTarifas = taw.obtenerTarifa(loitemLecturacion.getAnio(), loitemLecturacion.getMesf(), 7004, loitemLecturacion.getNcat());

            for (BsTaw tar : listTarifas) {
                int desde = tar.getDesd();
                int hasta = tar.getHast();
                double val1 = tar.getVal1();
                int cmon = tar.getCmon();

                String fiva = tar.getFiva().trim();
                String vafa = tar.getVafa().trim();

                if (cmon == 2) {  // en dolares convertir a bolivianos
                    val1 = val1 * dpw.getTcam();
                }

                char lfiva = fiva.charAt(0);
                char lvafa = vafa.charAt(0);
                if ('F' == lfiva && 'F' == lvafa) { // NO interesa el consumo
                    lfImporte = importeConsumo * (val1 / 100);
                } else if ('F' == lfiva && 'V' == lvafa) { // SI interesa el consumo
                    lfImporte = val1;
                }
            }
        }


        return lfImporte;
    }

    public double recuperacionInversion(int nhpf, double importeConsumo, BsHpw loitemLecturacion) {

        BsHpw hpw = new BsHpw();
        hpw.obtenerBsHpw(nhpf);
        BsDpw dpw = new BsDpw();
        dpw.obtenerDpw(hpw.getNhpf(), 7080);
        if (dpw.getNhpc() != 0) {
            BsTaw taw = new BsTaw();
            LinkedList<BsTaw> listTarifas = taw.obtenerTarifa(loitemLecturacion.getAnio(), loitemLecturacion.getMesf(), 7080, loitemLecturacion.getNcat());

            double lfImporte = 0;

            for (BsTaw tar : listTarifas) {
                int desde = tar.getDesd();
                int hasta = tar.getHast();
                double val1 = tar.getVal1();
                int cmon = tar.getCmon();

                String fiva = tar.getFiva().trim();
                String vafa = tar.getVafa().trim();

                if (cmon == 2) {  // en dolares convertir a bolivianos
                    val1 = val1 * dpw.getTcam();
                }

                char lfiva = fiva.charAt(0);
                char lvafa = vafa.charAt(0);
                if ('F' == lfiva && 'F' == lvafa) { // NO interesa el consumo
                    lfImporte = importeConsumo * (val1 / 100);
                }

                if ('F' == lfiva && 'V' == lvafa) { // SI interesa el consumo
                    lfImporte = val1;
                }
                if ('V' == lfiva && 'V' == lvafa) { // SI interesa el consumo
                    lfImporte = hpw.getCons() * val1;
                }
            }
            dpw.setPuni(lfImporte);
            dpw.registrarPrecioUnitario();

            dpw.setImpt(lfImporte);
            dpw.registrarImporte();

        }

        return 0;
    }


    public void registrarOtrosConceptos(BsHpw loitemLecturacion) {

        BsDpw detalle = new BsDpw();

        LinkedList<BsDpw> listDtl = detalle.obtenerOtrosDetalles(loitemLecturacion.getNhpf(), loitemLecturacion.getNcat());
        for (BsDpw dpw : listDtl) {

            dpw.setCant(1);
            dpw.registrarCantidad();

            double lfImporte = calcularOtrosImportes(dpw.getNhpc(), dpw.getTcam(), loitemLecturacion.getCons(),loitemLecturacion);
            dpw.setImpt(lfImporte);
            dpw.registrarImporte();

            double precioUnitario = lfImporte;
            dpw.setPuni(precioUnitario);
            dpw.registrarPrecioUnitario();
        }
    }

    public double calcularOtrosImportes(int liNhpc, double lfTcam, double lfConsumo, BsHpw loitemLecturacion) {

        BsTaw taw = new BsTaw();
        LinkedList<BsTaw> listTarifas = taw.obtenerTarifa(loitemLecturacion.getAnio(), loitemLecturacion.getMesf(), liNhpc, loitemLecturacion.getNcat());
        double lfImporte = 0;

        for (BsTaw tar : listTarifas) {
            int desde = tar.getDesd();
            int hasta = tar.getHast();
            double val1 = tar.getVal1();
            int cmon = tar.getCmon();
            String fiva = tar.getFiva().trim();
            String vafa = tar.getVafa().trim();
            if (cmon == 2) {  // en dolares convertir a bolivianos
                val1 = val1 * lfTcam;
            }
            char lfiva = fiva.charAt(0);
            char lvafa = vafa.charAt(0);
            if ('F' == lfiva && 'V' == lvafa) { // No interesa el consumo
                lfImporte = val1;
            }
            if ('V' == lfiva && 'V' == lvafa) { // SI interesa el consumo
                //lfImporte = lfImporte * (val1 / 100);
                //lfImporte =  new BigDecimal(lfImporte).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
                lfImporte = lfConsumo * val1;
            }
            if ('F' == lfiva && 'F' == lvafa) { // NO interesa el consumo
                lfImporte = lfConsumo * (val1 / 100);
            }
        }
        lfImporte =  new BigDecimal(lfImporte).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        return lfImporte;
    }

    public Double AnalisisImporte(Double consumo, Double valor, int cmon, Double tcam, String fiva, String vafa) {
        Double importe = -1.0;
        if (cmon == 2) {  // en dolares convertir a bolivianos
            valor = valor * tcam;
        }
        char lfiva = fiva.charAt(0);
        char lvafa = vafa.charAt(0);
        if ('F' == lfiva && 'V' == lvafa) { // NO interesa el consumo
            importe = valor;
        } else if ('V' == lfiva && 'V' == lvafa) { // SI interesa el consumo
            importe = consumo * valor;
        } else if (lfiva == 'F' && lvafa == 'F') {  //'--- No interesa el consumo interesa el Importe que viene
            importe = importe * (valor / 100);
            importe =  new BigDecimal(importe).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        }


        return importe;
    }


}