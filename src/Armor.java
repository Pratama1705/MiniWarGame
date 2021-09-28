public class Armor {
    public String nama_armor;
    public double def;

    Armor(int x){
        switch (x) {
            case 1:
                this.nama_armor = "Tameng Besi";
                this.def = 10; 
                break;
            case 2:
                this.nama_armor = "Baju Diamond";
                this.def = 30; 
                break;
            case 3:
                this.nama_armor = "Baju Besi";
                this.def = 20; 
                break;
            default:
                System.out.println("Anda salah memilih pilihan anda, anda pantas untuk kalah !");
                break;
        }
    }

    public String display(){
        return "Pertahanan yang digunakan adalah " + this.nama_armor + " dengan kekuatan " + this.def;
    }
}
