package pe.edu.tecsup.hibernate;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.edu.tecsup.hibernate.dao.ProgramaDAO;
import pe.edu.tecsup.hibernate.model.Programa;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProgramaDAOTests {

    @Autowired
    ProgramaDAO programaDAO;

    //@Test
    public void verifyList() {

        List<Programa> programas = programaDAO.list();
        for (Programa programa : programas) {
            System.out.println(programa.getId());
            System.out.println(programa.getNombre());
        }
        Assert.assertTrue(programas.size() > 0);
    }

    //@Test
    public void verifyFind() {
        Programa programa = programaDAO.get(64l);
        System.out.println(programa.getNombre());
        Assert.assertTrue(programa.getId() == 64l);
    }

    @Test
    public void verifySave() {

        Programa programa = new Programa();
        programa.setCodigo("2099");
        programa.setNombre("Programa Integral Nuevo");
        programa.setDescripcion("Programa de Jorge");

        programaDAO.save(programa);
        Assert.assertTrue(programa.getId() != null);
    }

    //@Test
    public void verifyUpdate() {

        // cambiar el código para validar
        Programa programa = new Programa();
        programa.setId(64l);
        programa.setCodigo("10287");
        programa.setNombre("Programa Modificado Jorge");

        programaDAO.update(programa);
        Assert.assertTrue(programaDAO.get(64l).getCodigo().equals("10287"));
    }

    //@Test
    public void verifyDelete() {

        Programa programa = new Programa();
        programa.setId(65l);
        programaDAO.delete(programa);

        Assert.assertTrue(programaDAO.get(65l) == null);
    }

}
