public class NBody{
    // read the radius of the universe
    public static double readRadius(String file){
        In in=new In(file);
        in.readInt();
        return in.readDouble();
    }

    // read the datas of Planets
    public static Planet[] readPlanets(String file){
        int i=0;
        In in=new In(file);
        Planet[] planet=new Planet[in.readInt()];

        in.readDouble();

        while(i<planet.length){
            planet[i]=new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
            i+=1;
        }
        return planet;
    }

    public static void main(String[] args){
        double T=Double.parseDouble(args[0]),dt=Double.parseDouble(args[1]);
        String filename=args[2];//"data/planets.txt";//args[2];
        Planet[] planets = readPlanets(filename);
        double time=0;
        double radius=readRadius(filename);
        double[] xForce=new double[planets.length];
        double[] yForce=new double[planets.length];
        

        StdDraw.setScale(-readRadius(filename),readRadius(filename));
        StdDraw.enableDoubleBuffering();

        int i=0;
        while(time!=T){
            StdDraw.clear();
            i=0;
            while(i<planets.length){
                xForce[i]=planets[i].calcNetForceExertedByX(planets);
                yForce[i]=planets[i].calcNetForceExertedByY(planets);
                i+=1;
            }
            i=0;
            while(i<planets.length){
                planets[i].update(dt,xForce[i],yForce[i]);
                i+=1;
            }
            StdDraw.picture(0,0,"images/starfield.jpg");
            i=0;
            while(i<planets.length){
                planets[i].draw();
                i+=1;
            }
            StdDraw.show();
            StdDraw.pause(10);
            time+=dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (i = 0; i < planets.length; i++) {
        StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
            planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        } 
    }
}
