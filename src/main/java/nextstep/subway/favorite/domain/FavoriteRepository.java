package nextstep.subway.favorite.domain;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    @Query("SELECT f FROM Favorite f WHERE f.id <= :favoriteId AND f.memberId = :memberId")
    List<Favorite> findByMemberIdOrderByIdDesc(@Param("favoriteId") Long favoriteId, @Param("memberId") Long memberId,
                                               Pageable pageable);

    Optional<Favorite> findFirstByMemberIdOrderByIdDesc(Long memberId);
}
