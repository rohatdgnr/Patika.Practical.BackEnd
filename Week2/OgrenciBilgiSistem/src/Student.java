public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course matquiz;
    Course fizik;
    Course fizikquiz;
    Course kimya;
    Course kimyaquiz;
    double avarage;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat,Course matquiz,Course fizik,Course fizikquiz,Course kimya,Course kimyaquiz) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.matquiz=matquiz;
        this.fizik = fizik;
        this.fizikquiz=fizikquiz;
        this.kimya = kimya;
        this.kimyaquiz=kimyaquiz;
        calcAvarage();
        this.isPass = false;
    }


    public void addBulkExamNote(int mat, int fizik, int kimya,int matquiz,int fizikquiz, int kimyaquiz) {

        if (mat >= 0 && mat <= 100) {
            this.mat.note = mat;
        }
        if (mat >= 0 && mat <= 100) {
            this.matquiz.note = matquiz;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.note = fizik;
        }
        if (fizikquiz >= 0 && fizikquiz <= 100) {
            this.fizikquiz.note = fizikquiz;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.note = kimya;
        }

        if (kimyaquiz >= 0 && kimyaquiz <= 100) {
            this.kimyaquiz.note = kimyaquiz;
        }

    }

    public void isPass() {
        if (this.mat.note == 0 ||this.matquiz.note == 0|| this.fizik.note == 0 ||this.fizikquiz.note==0|| this.kimya.note == 0||this.kimyaquiz.note==0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        this.avarage = (((this.fizik.note*0.8)+(this.fizikquiz.note*0.2)) + ((this.kimya.note*0.8)+(this.kimyaquiz.note*0.2)) + ((this.mat.note*0.8)+(this.matquiz.note*0.2))) / 3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note);
        System.out.println("Matematik Quiz Notu : " + this.matquiz.note);
        System.out.println("Fizik Notu : " + this.fizik.note);
        System.out.println("Fizik Quiz Notu : " + this.fizikquiz.note);
        System.out.println("Kimya Notu : " + this.kimya.note);
        System.out.println("Kimya Quiz Notu : " + this.kimyaquiz.note);
    }

}