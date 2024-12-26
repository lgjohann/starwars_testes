package org.johann.starwars.common;

import org.johann.starwars.domain.Planet;

public class PlanetConstants {
    public static final Planet PLANET = new Planet("name", "climate", "terrain");
    public static final Planet INVALID_PLANET = new Planet(" ", " ", " ");
}
