import pandas as pd
import glob


if __name__ == "__main__":
    '''
    This file reads all of the files and aggregates them into a dataframe.
    It takes the union of all unique tuples of (name, sex).
    The unique names for male and females are found, and then split into different files
    based on M and F. Each file is alphabetically organized.
    '''


    # source for adding all the files into a single dataframe
    # -> https://stackoverflow.com/questions/20906474/import-multiple-csv-files-into-pandas-and-concatenate-into-one-dataframe
    names_path = 'data/names/'
    all_name_files = glob.glob(names_path + '/*.txt')

    li = []

    for fn in all_name_files:
        df = pd.read_csv(fn, index_col=None, header=None)
        li.append(df)

    main_names = pd.concat(li, axis=0, ignore_index=True)

    main_names.drop([2], axis=1, inplace=True)

    print('Original # of names: {}'.format(len(main_names)))

    main_names.drop_duplicates(inplace=True)

    main_names.sort_values([0], inplace=True)

    main_names.reset_index(drop=True, inplace=True)

    main_names.rename(columns={0: 'name', 1: 'sex'}, inplace=True)

    print('Unique # of names: {}'.format(len(main_names)))

    names_F = main_names[main_names['sex'] == 'F']

    names_M = main_names[main_names['sex'] == 'M']

    names_F.drop('sex', axis=1, inplace=True)
    names_M.drop('sex', axis=1, inplace=True)

    names_F.to_csv('data/names/animal_names_F.csv',
                   encoding='utf-8', index=False, header=False)
    names_M.to_csv('data/names/animal_names_M.csv',
                   encoding='utf-8', index=False, header=False)

    pass
