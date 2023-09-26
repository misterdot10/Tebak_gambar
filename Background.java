import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bg_buah here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends World
{
    
        public static int jmlLebah = 2;
        public static int jmlBall = 2;
        public static int jmlJeruk = 2;
        public static int jmlRumput = 2;
        public static int jmlTong = 2;
        public static int jmlSalju = 2;
        public static int totalSoal = 12;
        Actor[] soal = new Actor[totalSoal];
        
        public static int counterKlik = 0;
        public static int maxCounterKlik = 2;
        
        public static boolean[] statusKlik = new boolean[totalSoal];
        
        int nilai = 0;
        
    /**
     * Constructor for objects of class bg_buah.
     * 
     */
    public Background()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 500, 1); 

        prepare();
    }
    
    public void act()
    {
        if(counterKlik >= maxCounterKlik)
        {
            Greenfoot.delay(10);
            counterKlik = 0;
            
            cekJawaban();
            
            for(int i=0; i<statusKlik.length; i++)
            {
                if(statusKlik[i] == true)
                {
                    statusKlik[i] = false;
                    
                    if(soal[i] != null)
                    {
                        soal[i].setImage("brick.jpg");
                    }
                    
                }
                
            }
            
        }
    }
    
    public void cekJawaban()
    {
        for(int i=0; i<soal.length; i++)
        {
            if(statusKlik[i] == true)
            {
                for(int j=i+1; j<soal.length; j++)
                {
                    if(statusKlik[j] == true)
                    {
                        if(soal[i].getClass() ==  soal[j].getClass())
                        {
                            nilai++;
                            soal[i] = null;
                            soal[j] = null;
                        }
                        
                    }
                    
                }
                
            }
            
        }
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        
        int counterLebah = 0;
        int counterBall = 0;
        int counterJeruk = 0;
        int counterRumput = 0;
        int counterTong = 0;
        int counterSalju = 0;
        
        int i=0;
        while( i < soal.length ) 
        {
            if(counterLebah < jmlLebah)
            {
                if(Greenfoot.getRandomNumber(10) > 5)
                {
                    soal[i] = new Lebah(i);
                    counterLebah++;
                    i++;
                    continue;
                }
            }
            
            if(counterBall < jmlBall)
            {
                if(Greenfoot.getRandomNumber(10) > 5)
                {
                    soal[i] = new Ball(i);
                    counterBall++;
                    i++;
                    continue;
                }
            }
            
            if(counterJeruk < jmlJeruk)
            {
                if(Greenfoot.getRandomNumber(10) > 5)
                {
                    soal[i] = new Jeruk(i);
                    counterJeruk++;
                    i++;
                    continue;
                }
            }
            
            if(counterRumput < jmlRumput)
            {
                if(Greenfoot.getRandomNumber(10) > 5)
                {
                    soal[i] = new Rumput(i);
                    counterRumput++;
                    i++;
                    continue;
                }
            }
            
            if(counterTong < jmlTong)
            {
                if(Greenfoot.getRandomNumber(10) > 5)
                {
                    soal[i] = new Tong(i);
                    counterTong++;
                    i++;
                    continue;
                }
            }
            
            if(counterSalju < jmlSalju)
            {
                if(Greenfoot.getRandomNumber(10) > 5)
                {
                    soal[i] = new Salju(i);
                    counterSalju++;
                    i++;
                    continue;
                }
            }
        }
        
        int koorX = 80;
        int koorY = 80;
        
        for(int j=0; j < soal.length; j++)
        {
            addObject(soal[j], koorX, koorY);
            koorX += 150;
            
            if(koorX > getWidth() )
            {
                koorX = 80;
                koorY += 150;
            }
            
        }
        
        
    }
}