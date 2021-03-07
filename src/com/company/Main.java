package com.company;

import com.company.Controllers.FTEController;
import com.company.Controllers.PTEController;
import com.company.Data.Interfaces.IDB;
import com.company.Data.PostgreSQL;
import com.company.Repository.FTERepository;
import com.company.Repository.Interfaces.IFTERepository;
import com.company.Repository.Interfaces.IPTERepository;
import com.company.Repository.PTERepository;

public class Main {

    public static void main(String[] args) {
        IDB idb = new PostgreSQL();
        IFTERepository FTERepository = new FTERepository(idb);
        IPTERepository PTERepository= new PTERepository(idb);
        PTEController PTEController = new PTEController(PTERepository);
        FTEController FTEController = new FTEController(FTERepository);
        Application Application = new Application(FTEController, PTEController);
        Application.start();
    }
}
