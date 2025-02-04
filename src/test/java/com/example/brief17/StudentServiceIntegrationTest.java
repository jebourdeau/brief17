package com.example.brief17;

import com.example.brief17.entity.Student;
import com.example.brief17.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ActiveProfiles("test")
@Import(StudentService.class)
// TODO: Ajouter les tags nécessaires pour charger H2, charger le profil de test et importer le StudentService
class StudentServiceIntegrationTest {
    @Autowired
    private StudentService studentService;

    @Test
    void shouldSaveAndRetrieveStudent() {
        // TODO: Implémenter le test d'intégration, insérer un Student en base de données et le récupérrer
        Student student= new Student();
        student.setName("Clara Morgan");
        student.setAddress("impasse des annusses");

        Student saveStudent= studentService.saveStudent(student);

        Student retrouveStudent = studentService.findStudentById(saveStudent.getId()).orElse(null);

            assertThat(retrouveStudent).isNotNull();
            assertThat(retrouveStudent.getName()).isEqualTo("Clara Morgan");
            assertThat(retrouveStudent.getAddress()).isEqualTo("impasse des annusses");

    }
}