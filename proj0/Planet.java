public class Planet{
    static final double G=6.67e-11;
    double xxPos;// Its current x position
    double yyPos;// Its current y position
    double xxVel;// Its current velocity in the x direction
    double yyVel;// Its current velocity in the y direction
    double mass;// Its mass
    String imgFileName;

    // initalize the Planet
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos=xP;yyPos=yP;xxVel=xV;yyVel=yV;
        mass=m;
        imgFileName=img;
    }

    public Planet(Planet p){
        xxPos=p.xxPos;
        yyPos=p.yyPos;
        xxVel=p.xxVel;
        yyVel=p.yyVel;
        mass=p.mass;
        imgFileName=p.imgFileName;
    }

    // calculate the distance between p and now
    public double calcDistance(Planet p){
        return Math.sqrt(Math.pow(p.xxPos-xxPos,2)+Math.pow(p.yyPos-yyPos,2));
    }

    // calculate the force exerted by p
    public double calcForceExertedBy(Planet p){
        return G*mass*p.mass/Math.pow(this.calcDistance(p),2);
    }

    // the x or y componet of force
    public double calcForceExertedByX(Planet p){
        return this.calcForceExertedBy(p)*(p.xxPos-this.xxPos)/this.calcDistance(p);
    }

    public double calcForceExertedByY(Planet p){
        return this.calcForceExertedBy(p)*(p.yyPos-this.yyPos)/this.calcDistance(p);
    }

    // is equal to itself
    private boolean equals(Planet p){
        if(p==this)
            return true;
        else
            return false;
    }

    // calculate the total x or y componet of force
    public double calcNetForceExertedByX(Planet[] allplanets){
        int i=0;
        double force=0;

        while(i<allplanets.length){
            if(!this.equals(allplanets[i]))
                force+=calcForceExertedByX(allplanets[i]);
            i+=1;
        }

        return force;
    }

    public double calcNetForceExertedByY(Planet[] allplanets){
        int i=0;
        double force=0;

        while(i<allplanets.length){
            if(!this.equals(allplanets[i]))
                force+=calcForceExertedByY(allplanets[i]);
            i+=1;
        }

        return force;
    }

    // forlupdate methods
    private double[] accel(double fx, double fy){
        return new double[]{fx/mass,fy/mass};
    }

    private void velocity(double[] accel, double dt){
        xxVel=xxVel+accel[0]*dt;
        yyVel=yyVel+accel[1]*dt;
    }

    public void update(double dt, double fx, double fy){
        velocity(accel(fx, fy), dt);
        xxPos+=xxVel*dt;
        yyPos+=yyVel*dt;
    }

    // to draw the planet in the current position
    public void draw(){

        StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
    }
}
