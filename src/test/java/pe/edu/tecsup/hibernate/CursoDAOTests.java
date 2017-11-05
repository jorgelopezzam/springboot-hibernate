package pe.edu.tecsup.hibernate;

import java.util.List;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.edu.tecsup.hibernate.dao.CursoDAO;
import pe.edu.tecsup.hibernate.dao.ProgramaDAO;
import pe.edu.tecsup.hibernate.model.Curso;
import pe.edu.tecsup.hibernate.model.Programa;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CursoDAOTests {
    
    Date ahora = new Date();
    
    @Autowired
    CursoDAO cursoDAO;
    
    @Autowired
    ProgramaDAO programaDAO;

    //@Test
    public void verifyList() {

        List<Curso> cursos = cursoDAO.list();
        for (Curso curso : cursos) {
            System.out.println(curso.getId());
            System.out.println(curso.getNombre());
            System.out.println(curso.getFechaInicio());
            //System.out.println(curso.getPrograma());
        }
        Assert.assertTrue(cursos.size() > 0);
    }

    @Test
    public void verifyFind() {
        Curso curso = cursoDAO.get(70l);
        System.out.println(curso.getId());
        System.out.println(curso.getNombre());
        System.out.println(curso.getFechaInicio());
        System.out.println(curso.getPrograma().getNombre());
        Assert.assertTrue(curso.getId() == 70l);
    }

    //@Test
    public void verifySave() {

        Curso curso = new Curso();
        Programa programa = programaDAO.get(97l);
        curso.setCodigo("1982");
        curso.setNombre("Curso Java Basico Jorge");
        curso.setFechaInicio(ahora);
        curso.setPrograma(programa);

        cursoDAO.save(curso);
        Assert.assertTrue(curso.getId() != null);
    }

    //@Test
    public void verifyUpdate() {

        // cambiar el código para validar
        Curso curso = new Curso();
        curso.setId(64l);
        curso.setCodigo("10287");
        curso.setNombre("Curso Modificado Jorge");

        cursoDAO.update(curso);
        Assert.assertTrue(cursoDAO.get(64l).getCodigo().equals("10287"));
    }

    //@Test
    public void verifyDelete() {

        Curso curso = new Curso();
        curso.setId(27l);
        cursoDAO.delete(curso);

        Assert.assertTrue(cursoDAO.get(27l) == null);
    }

}
