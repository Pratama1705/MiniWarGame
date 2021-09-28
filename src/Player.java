public class Player {
    public String nama;
    public double nyawa;
    public double kekuatan;

    Senjata perang;
    Armor defense;
    
    Player(String nama, double nyawa){
        this.nama = nama;
        this.nyawa = nyawa;
    }

    public void pakaiSenjata(Senjata perang){
        this.perang = perang;
    }

    public void pakaiArmor(Armor defense){
        this.defense = defense;
        this.nyawa += this.defense.def;
    }

    public void display(){
        System.out.println("Nama player : " + this.nama);
        System.out.println("Nyawa : " + this.nyawa);
        this.perang.display();
        this.defense.display();
    }
}
