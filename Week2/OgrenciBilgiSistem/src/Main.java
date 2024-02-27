public class Main {
    public static void main(String[] args) {

        Course mat = new Course("Matematik", "MAT101", "MAT");
        Course fizik = new Course("Fizik", "FZK101", "FZK");
        Course kimya = new Course("Kimya", "KMY101", "KMY");
        Course matquiz = new Course("Matematik", "MAT101", "MAT");
        Course fizikquiz = new Course("Fizik", "FZK101", "FZK");
        Course kimyaquiz = new Course("Kimya", "KMY101", "KMY");

        Teacher t1 = new Teacher("Mahmut Hoca", "90550000000", "MAT");
        Teacher t2 = new Teacher("Fatma Ayşe", "90550000001", "FZK");
        Teacher t3 = new Teacher("Ali Veli", "90550000002", "KMY");

        mat.addTeacher(t1);
        fizik.addTeacher(t2);
        kimya.addTeacher(t3);


        Student s1 = new Student("İnek Şaban", 4, "140144015", mat, fizik, kimya,matquiz,fizikquiz,kimyaquiz);
        s1.addBulkExamNote(50,50,60,70,20,40);
        s1.isPass();

        Student s2 = new Student("Güdük Necmi", 4, "2211133", mat, fizik, kimya,matquiz,fizikquiz,kimyaquiz);
        s2.addBulkExamNote(100,50,40,60,40,50);
        s2.isPass();

        Student s3 = new Student("Hayta İsmail", 4, "221121312", mat, fizik, kimya,matquiz,fizikquiz,kimyaquiz);
        s3.addBulkExamNote(50,20,40,70,80,100);
        s3.isPass();

    }
}