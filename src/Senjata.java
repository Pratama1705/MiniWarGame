public class Senjata {
    public double attPower;
    public String senjata;
    
    Senjata(int kekuatan){
        switch (kekuatan) {
            case 1:
                this.senjata = "Pedang";
                this.attPower = 15;
                break;
            case 2:
                this.senjata = "Samurai";
                this.attPower = 20;
                break;
            case 3:
                this.senjata = "Parang";
                this.attPower = 10;
                break;
            default:
                System.out.println("Anda salah memilih pilihan anda, anda pantas untuk kalah !");
                break;
        }
     }
    public String display(){
        return "Senjata yang digunakan adalah " + this.senjata + " dengan kekuatan " + this.attPower;
    }
}
