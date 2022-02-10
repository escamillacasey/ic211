public class Enigma{
  private Rotor rotIn;
  private Rotor rotMid;
  private Rotor rotOut;

  private final String[] rotors = {
    "#GNUAHOVBIPWCJQXDKRYELSZFMT",
    "#EJOTYCHMRWAFKPUZDINSXBGLQV",
    "#BDFHJLNPRTVXZACEGIKMOQSUWY",
    "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
    "#TGOWHLIFMCSZYRVXQABUPEJKND"};


  public Enigma(int id1,int id2,int id3, String startPoints){
    Rotor tmp1 = new Rotor(rotors[id1-1]);
    this.rotIn = tmp1;
    Rotor tmp2 = new Rotor(rotors[id2-1]);
    this.rotMid = tmp2;
    Rotor tmp3 = new Rotor(rotors[id3-1]);
    this.rotOut = tmp3;

    while(!this.rotIn.charAt(0).equals(startPoints.substring(0,1))){
      this.rotIn.rotateRight();
    }
    while(!this.rotMid.charAt(0).equals(startPoints.substring(1,2))){
      this.rotMid.rotateRight();
    }
    while(!this.rotOut.charAt(0).equals(startPoints.substring(2))){
      this.rotOut.rotateRight();
    }
  }

  public String encrypt(String message){
    int tempInt = 0;
    String tempString;
    String text = "";
    String tempS;
    for(int i = 0; i < message.length(); i++){
      tempInt = this.rotIn.returnLoc(message.substring(i,i+1));
      tempString = this.rotOut.charAt(tempInt);
      tempInt = this.rotMid.returnLoc(tempString);
      text = text + this.rotOut.charAt(tempInt);

      this.rotIn.rotateRight();

      if((i+1)%26 == 0){
          this.rotMid.rotateRight();
      }
      if((i+1)%(26*26) == 0){
        this.rotOut.rotateRight();
      }
    }
    return text;
  }

  public String decrypt(String message){

    int tempInt = 0;
    String tempString;
    String text = "";
    for(int i = 0; i < message.length(); i++){
      tempInt = this.rotOut.returnLoc(message.substring(i,i+1));
      tempString = this.rotMid.charAt(tempInt);
      tempInt = this.rotOut.returnLoc(tempString);
      text = text + this.rotIn.charAt(tempInt);

      this.rotIn.rotateRight();

      if(i!=0){
        if(i%26 == 0){
          this.rotMid.rotateRight();
        }
        if(i%(676) == 0){
          this.rotOut.rotateRight();
        }
      }
    }
    return text;
  }

  public static void main(String[] args){
   Enigma machine = new Enigma(4,1,3, "NWC");
   System.out.println(machine.rotIn.getAlpha());
   System.out.println(machine.rotMid.getAlpha());
   System.out.println(machine.rotOut.getAlpha());

   System.out.print(machine.decrypt("AGRGZAOTWUMPUSUMYITGLBAHTG#TVNLQAOFI#BSJDZNVYIVESGHDKMEWUY#THWOKEWKLYDLAHKPWSJOFDHBP#FUXOOQUIEDAOSXORLGLCGPTMABYIUROBWSMYPKLJMDJDGIJISUJOVIIUMUQSX#BXFNBPPLVY#UWKGVQBXYXPGBAPUDVIVAIYEHMDGAWHNCHCLMRLYRLOGVRBNKUABOJSTYSWSGTORZILJCUHBOCRUWKCZQVBCPAUZJDVJKRSHUPYZDPPVYNHHZBWRGIBTPJC#RFGBKLQRIILFBWPMFTTPZ#UESJMDGIAASMHJNYBDZLPOX##RFGKJOCFXSRFKUPYZDF#OTBSMWZTDRILCFNX#YRIWFCCMVEYCYNG#QVMTKBMEHZBTTVZNZJYUMGQRLWJCFX#BUULFACGRVXSEHZHFAJYDPAHG#OKVZUASGHEXEIEGLMHIYYPPJYJLPXLGKLEWZTOLRWNBQHWXCIRMXYCQSZKBIJWWJADWKCFUEHALDGIM#P#JADYTTUUNDVZJZSGAKLFQDV#RTXL#RMMG#DP#JVEPSI#CCIODXBTH#CXSZ#MOBGBKCWFIQ#NPP#MMQRKBPA#HQDSTVPLEPHDKPGSJSYAHCDBYEGULFLVXKPHSALOYDFLVNQLEZAUIUTNZOKBQRULRSQLUV#LKSWLWFX#UPREPYFYGU#K#THGBTCQJCRSOHDIORSL#SLRKRSHUPYZTTWY#ZOJYMSBEMWKOEEVQNBPUPQOSDO#VWUFJQDVEYJUJXXOYRUWXCFFAJPNGJHACGVGQXA#XEEJDIAEASOKIJKFYPSMHEOZOGAZGPFXKGOSRAVFMUYLRBUMWFURWUMCDJCDBXFUCFMHW#ONRTOAGMM##OSQJVTVRCYACN#MZJQJYTEBSXSTRMVWAMEIR#VDEJLQTRKPGKTXOCDPZWUAFDKBQRULNIRVTMPUGBKLRFCAFPOJUDORZI#MRLFEOFQFY#NHHKBBXFGZZQ#FZYBRWHSCQVQNBPUAXOVZHILCDGHKPPHYWNQIXBMTETMAWEFKWRREJBZOSYPDAUPQTFRCUNIRSXDNBILLFDLWMOB"));




   }

}

