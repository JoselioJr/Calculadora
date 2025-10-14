package com.joselio.Calculadora;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class MathController {
    @RequestMapping(value="/soma/{n1}/{n2}", method=RequestMethod.GET)
    public double soma(
        @PathVariable(value="n1") String n1, 
        @PathVariable(value="n2") String n2) throws Exception {
        if ((!isNumeric(n1))||(!isNumeric(n2))) {
            throw new Exception();
        }
        return(convertToDouble(n1) + convertToDouble(n2));
    }

    @RequestMapping(value="/subtracao/{n1}/{n2}", method=RequestMethod.GET)
    public double subtracao(
        @PathVariable(value="n1") String n1, 
        @PathVariable(value="n2") String n2) throws Exception {
        if ((!isNumeric(n1))||(!isNumeric(n2))) {
            throw new Exception();
        }
        return(convertToDouble(n1) - convertToDouble(n2));
    }

    @RequestMapping(value="/multiplicacao/{n1}/{n2}", method=RequestMethod.GET)
    public double multiplicacao(
        @PathVariable(value="n1") String n1, 
        @PathVariable(value="n2") String n2) throws Exception {
        if ((!isNumeric(n1))||(!isNumeric(n2))) {
            throw new Exception();
        }
        return(convertToDouble(n1) * convertToDouble(n2));
    }

    @RequestMapping(value="/divisao/{n1}/{n2}", method=RequestMethod.GET)
    public double divisao(
        @PathVariable(value="n1") String n1, 
        @PathVariable(value="n2") String n2) throws Exception {
        if ((!isNumeric(n1))||(!isNumeric(n2))) {
            throw new Exception();
        }
        return(convertToDouble(n1) / convertToDouble(n2));
    }

    @RequestMapping(value="/raizquadrada/{n1}", method=RequestMethod.GET)
    public double raizQuadrada(
        @PathVariable(value="n1") String n1) throws Exception {
        if ((!isNumeric(n1))) {
            throw new Exception();
        }
        return(Math.sqrt(convertToDouble(n1)));
    }

    @RequestMapping(value="/raizcubica/{n1}", method=RequestMethod.GET)
    public double raizCubica(
        @PathVariable(value="n1") String n1) throws Exception {
        if ((!isNumeric(n1))) {
            throw new Exception();
        }
        return(Math.cbrt(convertToDouble(n1)));
    }

    @RequestMapping(value="/potencia/{n1}/{potencia}", method=RequestMethod.GET)
    public double potencia(
        @PathVariable(value="n1") String n1, 
        @PathVariable(value="potencia") String potencia) throws Exception {
        if ((!isNumeric(n1))||(!isNumeric(potencia))) {
            throw new Exception();
        }
        return(Math.pow(convertToDouble(n1), convertToDouble(potencia)));
    }

    @RequestMapping(value="/binario/{n1}", method=RequestMethod.GET)
    public String binario(
        @PathVariable(value="n1") String n1) throws Exception {
        if ((!isNumeric(n1))) {
            throw new Exception();
        }
        return(Long.toString(Double.valueOf(convertToDouble(n1)).longValue(), 2));
    }

    @RequestMapping(value="/elevaro10/{potencia}", method=RequestMethod.GET)
    public double elevarAo10aUmaPotencia(
        @PathVariable(value="potencia") String potencia) throws Exception {
        if ((!isNumeric(potencia))) {
            throw new Exception();
        }
        return(Math.pow(10, convertToDouble(potencia)));
    }

    @RequestMapping(value="/fatorial/{n1}", method=RequestMethod.GET)
    public double fatorial(
        @PathVariable(value="n1") String n1) throws Exception {
        if ((!isNumeric(n1))) {
            throw new Exception();
        }
        double fat = 1;
        for (int i = 1; i <= convertToDouble(n1); i++) {
            fat *= i;
        }
        return(fat);
    }

    @RequestMapping(value="/pi", method=RequestMethod.GET)
    public double pi() {
        return(Math.PI);
    }

    private double convertToDouble(String strNumber) throws Exception {
        if (strNumber == null) throw new Exception();
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return (Double.parseDouble(number));
        else throw new Exception();
    }
    
    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
