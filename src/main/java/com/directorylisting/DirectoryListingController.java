package com.directorylisting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class DirectoryListingController {
    /**
     * Returns a string with directory file names
     * @param directoryPath - base64 encoded String
     * @return list of file names
     */
    @GetMapping("/directory-listing/{directoryPath}")
    public String directoryListing(@PathVariable String directoryPath) {
        byte[] decodedDirectoryPathBytes = Base64.getDecoder().decode(directoryPath);
        String decodedDirectoryPath = new String(decodedDirectoryPathBytes);

        List<String> fileNames = getFilelist(decodedDirectoryPath);
        String fileListing = "";

        for (String value:fileNames) {
            fileListing += value + "\n";
        }

        return fileListing;
    }

    private List<String> getFilelist(String dir) {
        return Stream.of(new File(dir).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toList());
    }
}
