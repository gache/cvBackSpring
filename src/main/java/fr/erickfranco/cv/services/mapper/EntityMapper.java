package fr.erickfranco.cv.services.mapper;

import java.util.List;
/**
 * @author Erick Franco
 */
public interface EntityMapper<D,E> {
    E toEntity(D dto);

    D toDto(E entity);

    List <E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);
}
