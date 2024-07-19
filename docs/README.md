# Introduction
With Recipes you can write your first draft using our built-in or custom guides.

Unlike other writing software, **you can't edit**.<br> You write here, and then export to use where you usually edit such as Org-Roam, Obsidian or Logseq.


## Getting Started
If you have [npm installed](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm)

1. `npm install`
2. `npm run start`



## Instructions
Recipes uses keyboard based navigation. <br>
You perform actions by first opening the command panel, and then typing what you want the application to do. <br>
*(It's not AI, so you need to follow the particular formats shown below)*

1. Open the command panel with the keyboard shortcut `Ctrl + Space`, or by pressing the `` ` `` key.

2. Enter any of the commands below:
- `help` : shows instructions
- `close` : hides instructions
- `start <guide>` : clears the current entry and starts a guided flow. Options are: `poem`, `dream`, and `journal`. <br>
for example, `start poem` will start the recipe for writing a poem.
- `next` : moves to the next step in the current guide!
- `add <surface>` : adds a writing surface. Options are: `markdown`, `poem` and `plain`. It defaults to `markdown`
- `recycle`: clears the current entry
- `save`: exports your entry based on your configuration file
- `exit`: exits the application

## Make Your Own Guides
The true joy of Recipes is when you go off script and create your own guides. <br>
There may be a particular structure that you love (mine is [the work](https://thework.com/) by Byron Katie)

You can create your own guides by adding a file at
**~/.writing-recipes/recipes.edn** and it will be added to the available recipes.
For example, this is the recipe for a Dream Journal:

``` edn
[
 {:name "Dream Journal"
  :alias ["d" ""]
  :surfaces [{:title "Where?"
              :type "markdown"
              :description "where was the dream set?"}
             {:title "What?"
              :type "markdown"
              :description "what was the dream about?"}]}
]
```

## Custom Configuration
By default Recipes saves a markdown file to the current directory, but you can create a configuration file to change it. Recipes looks for a config file at **~/.writing-recipes/profile.edn**

1. `default-storage` : which type of file to export, options are `markdown` and `org-roam`

2. `org-storage-path` : absolute path to store org-roam files. Note that you'll need to call org-roam-db-sync before you can find any new files created.

3. `markdown-storage-path` : absolute path to store markdown files.

``` edn
{:name "<your name>",
 :default-storage "markdown",
 :org-storage-path "<path-to-store-org-files>"
 :markdown-storage-path "<path-to-store-markdown-files>"
```

## Contributing
1.  You can submit guides to the community by opening an issue
2.  You can submit code like new writing surfaces or export targets.
