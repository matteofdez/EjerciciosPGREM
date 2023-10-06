import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {
    private List<Carta> cartas;
    private List<Carta> monton;

    public Baraja() {
        cartas = new ArrayList<>();
        monton = new ArrayList<>();
        String[] palos = {"espadas", "bastos", "oros", "copas"};

        for (String palo : palos) {
            for (int numero = 1; numero <= 12; numero++) {
                if (numero != 8 && numero != 9) {
                    cartas.add(new Carta(numero, palo));
                }
            }
        }
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public Carta siguienteCarta() {
        if (!cartas.isEmpty()) {
            Carta carta = cartas.remove(0);
            monton.add(carta);
            return carta;
        } else {
            System.out.println("No hay más cartas en la baraja.");
            return null;
        }
    }

    public int cartasDisponibles() {
        return cartas.size();
    }

  public List<Carta> darCartas(int numCartas) {
    List<Carta> cartasADar = new ArrayList<>();
    if (numCartas <= cartas.size()) {
        for (int i = 0; i < numCartas; i++) {
            Carta carta = siguienteCarta();
            if (carta != null) {
                cartasADar.add(carta);
            }
        }
    } else {
        System.out.println("No hay suficientes cartas para dar.");
    }
    return cartasADar;
}



public List<Carta> cartasMonton() {
    if (monton.isEmpty()) {
        System.out.println("No se ha sacado ninguna carta aún.");
    } else {
        return monton;
    }
    return Collections.emptyList(); // Si no hay cartas en el montón, retorna una lista vacía
}
public void mostrarBaraja() {
    List<Carta> copiaBaraja = new ArrayList<>(cartas);
    for (Carta carta : monton) {
        copiaBaraja.add(carta);
    }

    for (Carta carta : copiaBaraja) {
        System.out.println(carta);
    }
}

}
