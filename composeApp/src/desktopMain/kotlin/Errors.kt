class SourceLoadingError(source: String, file: String, path: String) :
    Exception("Can't load script $source($file) (attempted $path)")

class DescLoadingError(source: String, file: String, path: String) :
    Exception("Can't load descriptions for $source($file) (attempted $path)")

class FileLoadingError(path: String) :
    Exception("Failed to load cache: expected $path to exist, but can't load it")