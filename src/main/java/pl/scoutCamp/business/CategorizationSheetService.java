package pl.scoutCamp.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.scoutCamp.business.dao.CategorizationSheetDAO;
import pl.scoutCamp.domain.CategorizationSheet;
import pl.scoutCamp.domain.exception.NotFoundException;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CategorizationSheetService {

    CategorizationSheetDAO categorizationSheetDAO;

    public CategorizationSheet findCategorizationSheetById (int categorizationSheetId) {
        Optional<CategorizationSheet> categorizationSheet = categorizationSheetDAO.findCategorizationSheetById(categorizationSheetId);
        if (categorizationSheet.isEmpty()) {
            throw new NotFoundException("Could not find categorization sheet with id: [%s]".formatted(categorizationSheetId));
        }
        return categorizationSheet.get();
    }
}
