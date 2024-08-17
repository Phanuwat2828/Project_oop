public class test {
    public static void main(String[] args) {


            // Random_Mistake Methode
    // !สุ่มความผิดพลาด ตาม ค่าที่ส่งเข้ามา 
    // *ค่าที่ส่งเข้ามาคือ % ที่จะเกิดความผิดพลาด
    public static boolean randomTrueWith5PercentChance(Double random_) {
        Random random = new Random();

        // 0.0-0.99  < 0.5 true 0.00 0.01 0.02 0.03 0.04  5/100
        // &return True or False
        return random.nextDouble() < random_;
    }

    
        if(Data.randomTrueWith5PercentChance(0.05)){ // !โอกาสความผิดพลาด 5%
            data = data + (int) (Math.random() * (-data)+(int)data/2); //! สุ่มค่าความผิดพลาด เช่น pm 50  จะสุ่มตั้งแต่ -25 ถึง 25 แล้วเก็บลง data 
        }
    }
}
