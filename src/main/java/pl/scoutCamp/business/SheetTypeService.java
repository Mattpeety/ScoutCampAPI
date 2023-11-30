package pl.scoutCamp.business;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.scoutCamp.business.dao.SheetTypeDAO;
import pl.scoutCamp.domain.SheetType;
import pl.scoutCamp.domain.exception.NotFoundException;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class SheetTypeService {

    SheetTypeDAO sheetTypeDAO;

    @Transactional
    public List<SheetType> findAvailableSheetTypes() {
        List<SheetType> allSheetTypes = sheetTypeDAO.findSheetTypes();
        if (allSheetTypes.isEmpty()) {
            throw new NotFoundException("Could not find any sheet type");
        }
        log.info("all sheet types: [{}]", allSheetTypes);
        return allSheetTypes;
    }
}
