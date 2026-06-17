package ecomarket.catalogo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ecomarket.catalogo.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // findByCodigo() -> busca por ISBN (codigo unico del producto)
    Optional<Producto> findByIsbn(String isbn);

    // buscarPorNombre() -> coincidencia parcial en el titulo, sin distinguir mayusculas
    List<Producto> findByTituloContainingIgnoreCase(String titulo);

    // findByRangoPrecio()
    List<Producto> findByPrecioUnitarioBetween(Integer minimo, Integer maximo);

    // findByPrecioMaximo() -> productos con precio menor o igual al tope
    List<Producto> findByPrecioUnitarioLessThanEqual(Integer maximo);

    // findByPrecioMinimo() -> productos con precio mayor o igual al piso
    List<Producto> findByPrecioUnitarioGreaterThanEqual(Integer minimo);

    // findByCategoria() -> productos que pertenecen a una categoria dada
    List<Producto> findByCategorias_IdCategoria(Long idCategoria);
}
